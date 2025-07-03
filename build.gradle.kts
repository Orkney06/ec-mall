plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.serialization") version "1.9.25"
	id("org.springframework.boot") version "3.4.5"
	id("io.spring.dependency-management") version "1.1.7"
	id("org.graalvm.buildtools.native") version "0.10.6"
	alias(libs.plugins.flyway)
}

group = "com.ecmall"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	runtimeOnly("com.mysql:mysql-connector-j")
	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
	implementation(libs.exposed.core)
	implementation(libs.exposed.jdbc)
	implementation(libs.exposed.time)
	implementation("com.mysql:mysql-connector-j:8.2.0")
	implementation("org.flywaydb:flyway-core")
	implementation("org.apache.httpcomponents.client5:httpclient5:5.4.4")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

flyway {
	url = "jdbc:mysql://localhost:3307/ecmall"
	user = "root"
	password = "mall"
}
