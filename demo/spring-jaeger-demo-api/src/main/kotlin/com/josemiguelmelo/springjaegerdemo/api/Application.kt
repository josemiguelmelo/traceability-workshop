package com.josemiguelmelo.springjaegerdemo.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class UserRoleApplication

fun main(args: Array<String>) {
	runApplication<UserRoleApplication>(*args)
}
