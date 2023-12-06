package com.josemiguelmelo.springjaegerdemo.userroles.app.repository

import com.josemiguelmelo.springjaegerdemo.userroles.common.config.JacksonJsonParser.jsonObjectMapper
import org.springframework.stereotype.Service
import okhttp3.Call;
import okhttp3.Request

@Service
class APIOkhttpRepository(
    val callFactory: Call.Factory
) {
    private data class BeersResponse(
        val brand: String,
        val name: String
    )

    fun getRandomName() : String? {
        val request: Request = Request.Builder()
            .url("https://random-data-api.com/api/v2/beers")
            .get()
            .build()

        val response = callFactory.newCall(request).execute()

        val responseBody = response.body?.string() ?: return null

        return jsonObjectMapper.readValue(responseBody, BeersResponse::class.java).name
    }
}