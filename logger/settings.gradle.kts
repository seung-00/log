rootProject.name = "log"

dependencyResolutionManagement {
  repositories {
    mavenCentral()
  }

  versionCatalogs {
    create("libs") {
      version("spring-boot", "3.2.1")
      version("spring-boot-legacy", "3.1.2")
      version("spring-dep-mgmt", "1.1.4")
      version("kotlin", "1.9.21")
      version("kotlinx-serialization", "1.8.0")
      version("caffeine", "3.2.0")

      plugin("spring-boot", "org.springframework.boot").versionRef("spring-boot")
      plugin("spring-dep-mgmt", "io.spring.dependency-management").versionRef("spring-dep-mgmt")
      plugin("kotlin-jvm", "org.jetbrains.kotlin.jvm").versionRef("kotlin")
      plugin("kotlin-spring", "org.jetbrains.kotlin.plugin.spring").versionRef("kotlin")
      plugin("kotlin-serialization", "org.jetbrains.kotlin.plugin.serialization").versionRef("kotlin")

      library("spring-boot-starter", "org.springframework.boot", "spring-boot-starter").versionRef("spring-boot")
      library("spring-boot-starter-web", "org.springframework.boot", "spring-boot-starter-web").version("3.1.2")
      library("spring-boot-starter-test", "org.springframework.boot", "spring-boot-starter-test").versionRef("spring-boot")
      library("spring-boot-actuator", "org.springframework.boot", "spring-boot-starter-actuator").versionRef("spring-boot")
      library("kotlin-reflect", "org.jetbrains.kotlin", "kotlin-reflect").versionRef("kotlin")
      library("kotlinx-serialization-json", "org.jetbrains.kotlinx", "kotlinx-serialization-json").versionRef("kotlinx-serialization")
      library("caffeine", "com.github.ben-manes.caffeine", "caffeine").versionRef("caffeine")
    }
  }
}
