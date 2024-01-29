package com.logger.infrastructure.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "cloud.files")
data class FilesProperties(
    val path: String
)
