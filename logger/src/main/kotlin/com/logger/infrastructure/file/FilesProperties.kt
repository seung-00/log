package com.logger.infrastructure.file

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "cloud.files")
data class FilesProperties(
    val path: String
)
