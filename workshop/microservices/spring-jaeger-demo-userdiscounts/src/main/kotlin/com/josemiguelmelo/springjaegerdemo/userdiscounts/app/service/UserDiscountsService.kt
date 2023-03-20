package com.josemiguelmelo.springjaegerdemo.userdiscounts.app.service

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.josemiguelmelo.springjaegerdemo.userdiscounts.app.repository.CouponCodeAPIOkhttpRepository
import com.josemiguelmelo.springjaegerdemo.userdiscounts.app.repository.UserDiscountsRepository
import com.josemiguelmelo.springjaegerdemo.userdiscounts.common.model.UserDiscount
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class UserDiscountsService(
    private val userDiscountsRepository: UserDiscountsRepository,
    private val couponCodeAPIOkhttpRepository: CouponCodeAPIOkhttpRepository,
) {
    private val logger = LoggerFactory.getLogger(UserDiscountsService::class.java)

    fun listUserDiscount(userId: String): Flux<UserDiscount> {
        val discounts = userDiscountsRepository.findByUserId(userId)
        return Flux.fromIterable(discounts)
    }


    fun addDiscountForUser(userId: String, discountPercentage: Int) {
        val discountCode = couponCodeAPIOkhttpRepository.getRandomCouponCode()
            ?: throw Exception("Failed to generate discount code")

        val userDiscount = UserDiscount(
            userId = userId,
            discountPercentage = discountPercentage,
            code = discountCode
        )

        userDiscountsRepository.save(userDiscount)
        logger.info("Discount of $discountPercentage% associated to user $userId")
    }
}