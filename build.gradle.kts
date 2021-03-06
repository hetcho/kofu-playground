import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinVersion: String by project
val springBootVersion: String by project
val springKoFuVersion: String by project
val kotlinCoroutinesVersion: String by project

plugins {
	id("org.springframework.boot")
	id("io.spring.dependency-management")

	kotlin("jvm")
	kotlin("plugin.spring")
	kotlin("plugin.serialization")
}

group = "ru.hetcho"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
	maven("https://repo.spring.io/milestone")
}

dependencies {
	fun kotlinx(module: String, version: String) = "org.jetbrains.kotlinx:kotlinx-$module:$version"
	fun starter(module: String, version: String = springBootVersion) = "org.springframework.boot:spring-boot-starter-$module:$version"

	// Spring Boot
	implementation(starter("webflux"))
	implementation(starter("mustache"))
	implementation(starter("data-r2dbc"))

	// Spring KoFu
	implementation("org.springframework.fu:spring-fu-kofu:$springKoFuVersion")

	// Kotlin
	implementation(kotlin("reflect"))
	implementation(kotlin("stdlib-jdk8"))

	// Kotlinx
	implementation(kotlinx("coroutines-reactor", kotlinCoroutinesVersion))

	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")

	// Database
	runtimeOnly("com.h2database:h2")
	runtimeOnly("io.r2dbc:r2dbc-h2")

	// Test
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
