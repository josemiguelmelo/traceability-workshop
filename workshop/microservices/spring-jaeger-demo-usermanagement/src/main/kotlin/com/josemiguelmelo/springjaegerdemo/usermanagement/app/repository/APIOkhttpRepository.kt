package com.josemiguelmelo.springjaegerdemo.usermanagement.app.repository

import org.springframework.stereotype.Service
import okhttp3.Call;
import okhttp3.Request

@Service
class APIOkhttpRepository(
    val callFactory: Call.Factory
) {
    fun getRandomName() : String? {
        val request: Request = Request.Builder()
            .url("https://random-data-api.com/api/v2/beers")
            .get()
            .build()

        val response = callFactory.newCall(request).execute()

        return response.body?.string()
    }
}