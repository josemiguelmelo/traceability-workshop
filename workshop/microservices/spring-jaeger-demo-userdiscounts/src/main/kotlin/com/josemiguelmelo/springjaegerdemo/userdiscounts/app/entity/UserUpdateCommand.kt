package com.josemiguelmelo.springjaegerdemo.userdiscounts.app.entity

data class UserUpdateCommand(
    val identifier: String,
    val firstName: String
)