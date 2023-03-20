package com.josemiguelmelo.springjaegerdemo.userroles.common.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "roles")
data class Role(
    @Id val id: ObjectId = ObjectId.get(),
    val name: String
)