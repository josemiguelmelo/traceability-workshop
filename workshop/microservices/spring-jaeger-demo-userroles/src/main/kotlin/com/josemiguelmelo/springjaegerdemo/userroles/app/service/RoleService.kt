package com.josemiguelmelo.springjaegerdemo.userroles.app.service

import com.josemiguelmelo.springjaegerdemo.userroles.app.repository.APIOkhttpRepository
import com.josemiguelmelo.springjaegerdemo.userroles.app.repository.RolesRepository
import com.josemiguelmelo.springjaegerdemo.userroles.common.model.Role
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class RoleService(
    private val rolesRepository: RolesRepository,
    private val apiOkhttpRepository: APIOkhttpRepository,
){
    private val logger = LoggerFactory.getLogger(RoleService::class.java)

    fun defaultRole(): Mono<Role> {
        apiOkhttpRepository.getRandomName()?.let {
            logger.info("Fetched the following random name: $it")
        }

        return Mono.just(Role(name = "user:normal"))
    }
}