package com.josemiguelmelo.springjaegerdemo.api.common.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "quotes")
data class Quote(
    @Id val id: ObjectId = ObjectId.get(),
    val quote: String,
    val author: String
)