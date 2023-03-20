package com.josemiguelmelo.springjaegerdemo.api.common.client

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import okhttp3.Call
import okhttp3.Request
import org.springframework.stereotype.Component

data class Quote(
    val quote: String,
    val author: String
)

@Component
class QuotesApiClient(
    val callFactory: Call.Factory,
) {
    fun getRandomQuote(): Quote? {

        val request: Request = Request.Builder()
            .url("https://api.goprogram.ai/inspiration")
            .get()
            .build()

        val response = callFactory.newCall(request).execute()

        val responseString = response.body?.string() ?: return null
        return jacksonObjectMapper().readValue(responseString, Quote::class.java)
    }
}
