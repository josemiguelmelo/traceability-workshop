package com.josemiguelmelo.springjaegerdemo.api.app.repository

import com.josemiguelmelo.springjaegerdemo.api.common.model.Quote
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface QuoteRepository : MongoRepository<Quote, String>