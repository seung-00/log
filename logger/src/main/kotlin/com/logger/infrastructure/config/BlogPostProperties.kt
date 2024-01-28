package com.logger.infrastructure.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "blog.post")
data class BlogPostProperties(
    val path: String
)
