package com.josemiguelmelo.springjaegerdemo.userdiscounts.app.kafka

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.josemiguelmelo.springjaegerdemo.userdiscounts.app.entity.UserUpdateCommand
import com.josemiguelmelo.springjaegerdemo.userdiscounts.app.service.UserDiscountsService
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.slf4j.LoggerFactory
import org.springframework.cloud.sleuth.Span
import org.springframework.cloud.sleuth.Tracer
import org.springframework.cloud.sleuth.instrument.kafka.TracingKafkaPropagatorGetter
import org.springframework.cloud.sleuth.propagation.Propagator
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class UserUpdateListener(
    private val userDiscountsService: UserDiscountsService,
    private val tracer: Tracer,
    private val propagator: Propagator,
) {
    private val onCreationDiscountPercentage = 10
    private val logger = LoggerFactory.getLogger(UserUpdateListener::class.java)

    @KafkaListener(topics = ["user-update"])
    fun listenUserUpdates(@Payload message: String, record: ConsumerRecord<String, String>) {
        val spanBuilder: Span.Builder = this.propagator.extract(record, TracingKafkaPropagatorGetter())
        val span: Span = spanBuilder
            .name("consumer-continued")
            .tag("topic", record.topic())
            .start()
        try {
            tracer.withSpan(span).use { spanInScope ->
                logger.info("Received user update message: $message")
                val userUpdate = jacksonObjectMapper()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                    .readValue(message, UserUpdateCommand::class.java)

                if (userUpdate.firstName == "coupon") throw Exception("Empty firstName not allowed")
                userDiscountsService.addDiscountForUser(userUpdate.identifier, onCreationDiscountPercentage)
            }
        } catch (e: Exception) {
            span.error(e)
            throw e
        } finally {
            span.end()
        }
    }
}