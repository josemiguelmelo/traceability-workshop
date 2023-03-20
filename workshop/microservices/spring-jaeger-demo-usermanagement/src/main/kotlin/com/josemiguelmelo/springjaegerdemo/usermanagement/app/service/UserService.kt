package com.josemiguelmelo.springjaegerdemo.usermanagement.app.service

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.josemiguelmelo.springjaegerdemo.usermanagement.app.entity.CreateUserCommand
import com.josemiguelmelo.springjaegerdemo.usermanagement.app.repository.APIOkhttpRepository
import com.josemiguelmelo.springjaegerdemo.usermanagement.app.repository.UserRepository
import com.josemiguelmelo.springjaegerdemo.usermanagement.common.client.RolesApiClient
import com.josemiguelmelo.springjaegerdemo.usermanagement.common.model.User
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class UserService(
    private val userRepository: UserRepository,
    private val apiOkhttpRepository: APIOkhttpRepository,
    private val rolesApiClient: RolesApiClient,
    private val kafkaTemplate: KafkaTemplate<String, String>
) {
    private val logger = LoggerFactory.getLogger(UserService::class.java)

    fun findUserById(id: String): Mono<User> {
        return Mono.just(userRepository.findByIdentifier(id))
    }

    fun listUsers(): Flux<User> {
        return Flux.fromIterable(userRepository.findAll())
    }

    fun createUser(createUserCommand: CreateUserCommand): Mono<User> {
        val role = rolesApiClient.getDefaultRole()

        apiOkhttpRepository.getRandomName()

        val user = User(
            username = createUserCommand.username,
            password = createUserCommand.password,
            firstName = createUserCommand.firstName,
            lastName = createUserCommand.lastName,
            role = role
        )

        val userCreated = userRepository.save(user)
        sendUserUpdateToKafka(userCreated)
        return Mono.just(userCreated)
    }


    fun sendUserUpdateToKafka(user: User) {
        kafkaTemplate.send("user-update", user.identifier, jacksonObjectMapper().writeValueAsString(user))
    }
}