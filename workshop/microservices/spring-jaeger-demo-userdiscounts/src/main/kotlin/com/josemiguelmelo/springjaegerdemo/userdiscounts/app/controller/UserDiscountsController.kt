package com.josemiguelmelo.springjaegerdemo.userdiscounts.app.controller

import com.josemiguelmelo.springjaegerdemo.userdiscounts.common.model.UserDiscount
import com.josemiguelmelo.springjaegerdemo.userdiscounts.app.service.UserDiscountsService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/v1")
class UserDiscountsController(
    private val userDiscountsService: UserDiscountsService
) {
    private val logger = LoggerFactory.getLogger(UserDiscountsController::class.java)

    @GetMapping("/discounts")
    fun listUserDiscounts(@RequestParam userId: String): Flux<UserDiscount> {
        logger.info("Listing discounts for user $userId")
        return userDiscountsService.listUserDiscount(userId)
    }
}