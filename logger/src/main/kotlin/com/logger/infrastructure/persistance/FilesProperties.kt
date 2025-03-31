package com.logger.infrastructure.persistance

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "cloud.files")
data class FilesProperties(
    val path: String
)
