package com.josemiguelmelo.springjaegerdemo.api.common.client

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import okhttp3.Call
import okhttp3.Request
import org.springframework.stereotype.Component

data class Quote(
    val content: String,
    val author: String
)

@Component
class QuotesApiClient(
    val callFactory: Call.Factory,
) {
    fun getRandomQuote(): Quote? {

        val request: Request = Request.Builder()
            .url("https://api.quotable.io/random")
            .get()
            .build()

        val response = callFactory.newCall(request).execute()

        val responseString = response.body?.string() ?: return null
        return jacksonObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .readValue(responseString, Quote::class.java)
    }
}
