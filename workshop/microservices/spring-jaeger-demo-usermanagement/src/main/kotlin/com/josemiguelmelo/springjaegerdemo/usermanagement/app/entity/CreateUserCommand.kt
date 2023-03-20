package com.josemiguelmelo.springjaegerdemo.usermanagement.app.entity

import org.springframework.boot.autoconfigure.security.SecurityProperties.User

data class CreateUserCommand(
    val username: String,
    val password: String,
    val firstName: String,
    val lastName: String,
)