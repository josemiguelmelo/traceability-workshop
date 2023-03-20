package com.josemiguelmelo.springjaegerdemo.usermanagement.common.config

import io.opentelemetry.api.OpenTelemetry
import io.opentelemetry.instrumentation.okhttp.v3_0.OkHttpTelemetry
import okhttp3.Call
import okhttp3.OkHttpClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OkhttpConfig {
    @Bean
    fun okHttpClient(openTelemetry: OpenTelemetry): Call.Factory {
        return OkHttpTelemetry.builder(openTelemetry).build().newCallFactory(
            OkHttpClient.Builder().build()
        )
    }
}