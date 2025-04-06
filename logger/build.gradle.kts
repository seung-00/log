import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	alias(libs.plugins.spring.boot)
	alias(libs.plugins.spring.dep.mgmt)
	alias(libs.plugins.kotlin.jvm)
	alias(libs.plugins.kotlin.spring)
	alias(libs.plugins.kotlin.serialization)
}

group = "com"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation(libs.spring.boot.starter)
	implementation(libs.spring.boot.starter.web)
	implementation(libs.spring.boot.actuator)
	implementation(libs.kotlin.reflect)
	implementation(libs.kotlinx.serialization.json)
	implementation(libs.caffeine)

	testImplementation(libs.spring.boot.starter.test)
}

/**
 * integration 테스트 sourceSet
 */
sourceSets.create("intTest") {
	compileClasspath += sourceSets.main.get().output
	compileClasspath += configurations.testRuntimeClasspath.get()
	runtimeClasspath += output + compileClasspath
}

configurations.named("intTestImplementation") {
	extendsFrom(configurations.getByName("testImplementation"))
}

tasks.register<Test>("intTest") {
	description = "Runs integration test"
	group = "verification"

	testClassesDirs = sourceSets["intTest"].output.classesDirs
	classpath = sourceSets["intTest"].runtimeClasspath
	shouldRunAfter("test")

	useJUnitPlatform()

	testLogging {
		events("passed")
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.jar {
	enabled = false
}
