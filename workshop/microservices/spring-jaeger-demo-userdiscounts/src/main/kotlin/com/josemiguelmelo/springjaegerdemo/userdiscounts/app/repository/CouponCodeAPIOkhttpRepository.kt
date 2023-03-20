package com.josemiguelmelo.springjaegerdemo.userdiscounts.app.repository

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.stereotype.Service
import okhttp3.Call;
import okhttp3.Request

@Service
class CouponCodeAPIOkhttpRepository(
    val callFactory: Call.Factory
) {
    fun getRandomCouponCode() : String? {
        val request: Request = Request.Builder()
            .url("https://uuidtools.com/api/generate/v4")
            .get()
            .build()

        val response = callFactory.newCall(request).execute()

        val responseString = response.body?.string()

        return jacksonObjectMapper().readValue(responseString, object : TypeReference<List<String>>() {}).first()
    }
}