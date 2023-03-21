package com.josemiguelmelo.springjaegerdemo.usermanagement.app.controller

import com.josemiguelmelo.springjaegerdemo.usermanagement.app.entity.CreateUserCommand
import com.josemiguelmelo.springjaegerdemo.usermanagement.common.model.User
import com.josemiguelmelo.springjaegerdemo.usermanagement.app.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Profile
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/v1/users")
class UserController(
    private val userService: UserService
) {
    private val logger = LoggerFactory.getLogger(UserController::class.java)

    @PostMapping
    fun createUser(createUserCommand: CreateUserCommand): Mono<User> {
        logger.info("Creating new user $createUserCommand")
        return userService.createUser(createUserCommand = createUserCommand)
    }

    @PostMapping("/premium")
    fun createPremiumUser(
        createUserCommand: CreateUserCommand
    ): Mono<User> {
        logger.info("Creating new user with discount $createUserCommand")
        return userService.createUser(createUserCommand = createUserCommand, premium = true)
    }

    @GetMapping
    fun listUsers(): Flux<User> {
        logger.info("Listing users")
        return userService.listUsers()
    }

    @GetMapping("{id}")
    fun findUserById(@PathVariable id: String): Mono<User> {
        logger.info("Fetching user $id")
        return userService.findUserById(id)
    }
}