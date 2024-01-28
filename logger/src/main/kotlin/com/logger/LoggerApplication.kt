package com.logger

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan("com.logger")
@SpringBootApplication
class LoggerApplication

fun main(args: Array<String>) {
	runApplication<LoggerApplication>(*args)
}
