package com.josemiguelmelo.springjaegerdemo.usermanagement.app.entity

data class CreateUserCommand(
    val username: String?,
    val password: String?,
    val firstName: String?,
    val lastName: String?,
) {
    fun validate() {
        if(username.isNullOrBlank()) throw Exception("Invalid username")
        if(password.isNullOrBlank()) throw Exception("Invalid username")
        if(firstName.isNullOrBlank()) throw Exception("Invalid username")
        if(lastName.isNullOrBlank()) throw Exception("Invalid username")

        if(username.length <= 8) throw Exception("Username must have length of more than 8 chars")
    }
}