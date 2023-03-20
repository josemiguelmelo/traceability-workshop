package com.josemiguelmelo.springjaegerdemo.userdiscounts.app.repository

import com.josemiguelmelo.springjaegerdemo.userdiscounts.common.model.UserDiscount
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UserDiscountsRepository : MongoRepository<UserDiscount, String> {

    @Query(value = "{ 'userId' : ?0 }")
    fun findByUserId(userId: String): List<UserDiscount>
}