package com.josemiguelmelo.springjaegerdemo.usermanagement.common.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.UUID

@Document(collection = "users")
data class User(
    @Id val id: ObjectId = ObjectId.get(),
    val identifier: String = UUID.randomUUID().toString(),
    val username: String,
    val firstName: String,
    val lastName: String,
    val password: String,
    val role: String?
)