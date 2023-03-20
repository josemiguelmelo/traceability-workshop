package com.josemiguelmelo.springjaegerdemo.usermanagement.app.repository

import com.josemiguelmelo.springjaegerdemo.usermanagement.common.model.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : MongoRepository<User, String> {
    @Query(value = "{ 'identifier' : ?0 }")
    fun findByIdentifier(id: String): User

}