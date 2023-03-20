package com.josemiguelmelo.springjaegerdemo.userroles.app.controller

import com.josemiguelmelo.springjaegerdemo.userroles.app.service.RoleService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/v1")
class RolesController(
    private val roleService: RoleService
) {
    private val logger = LoggerFactory.getLogger(RolesController::class.java)

    @GetMapping("/roles/default-role")
    fun defaultRole(): Mono<String> {
        logger.info("Getting default role")
        return roleService.defaultRole().map { it.name }
    }
}