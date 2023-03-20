package com.josemiguelmelo.springjaegerdemo.userdiscounts.common.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "user-discounts")
data class UserDiscount(
    @Id val id: ObjectId = ObjectId.get(),
    val userId: String,
    val code: String,
    val discountPercentage: Int,
)