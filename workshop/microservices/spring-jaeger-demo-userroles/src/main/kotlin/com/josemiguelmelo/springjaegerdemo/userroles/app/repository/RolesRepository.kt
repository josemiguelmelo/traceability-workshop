package com.josemiguelmelo.springjaegerdemo.userroles.app.repository

import com.josemiguelmelo.springjaegerdemo.userroles.common.model.Role
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface RolesRepository : MongoRepository<Role, String>