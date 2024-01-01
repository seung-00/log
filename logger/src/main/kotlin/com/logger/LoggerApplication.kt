package com.logger

import com.logger.post.infrastructure.config.BlogPostProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan("com.logger")
@SpringBootApplication
class LoggerApplication

fun main(args: Array<String>) {
	runApplication<LoggerApplication>(*args)
}
