package com.josemiguelmelo.springjaegerdemo.userroles.common.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

data class ApiConfig(
    var baseUrl: String
)

@Configuration
@ConfigurationProperties(prefix = "external.apis")
data class ExternalApiConfig(
    var userRoles: ApiConfig = ApiConfig("")
)