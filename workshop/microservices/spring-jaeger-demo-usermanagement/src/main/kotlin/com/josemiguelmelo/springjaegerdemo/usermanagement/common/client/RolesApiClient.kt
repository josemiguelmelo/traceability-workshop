package com.josemiguelmelo.springjaegerdemo.usermanagement.common.client

import com.josemiguelmelo.springjaegerdemo.usermanagement.common.config.ExternalApiConfig
import okhttp3.Call
import okhttp3.Request
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Component
class RolesApiClient(
    val apiConfig: ExternalApiConfig,
    val callFactory: Call.Factory,
) {
    fun getDefaultRole(): String? {

        val request: Request = Request.Builder()
            .url("${apiConfig.userRoles.baseUrl}/api/v1/roles/default-role")
            .get()
            .build()

        val response = callFactory.newCall(request).execute()

        return response.body?.string()
    }
}
