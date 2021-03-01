rootProject.name = "kofu-playground"

pluginManagement {
    val kotlinVersion: String by settings
    val springBootVersion: String by settings
    val springDependencyManagerVersion: String by settings

    repositories {
        maven("https://repo.spring.io/milestone")
        maven("https://plugins.gradle.org/m2/")
    }

    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "org.springframework.boot") useModule("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
            if (requested.id.id == "io.spring.dependency-management") useModule("io.spring.gradle:dependency-management-plugin:$springDependencyManagerVersion")
            if (requested.id.namespace?.startsWith("org.jetbrains.kotlin") == true) useVersion(kotlinVersion)
        }
    }
}
