plugins {
    java
    id("org.springframework.boot") version "3.2.1"
    id("io.spring.dependency-management") version "1.1.4"
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation(libs.org.springframework.boot.spring.boot.starter.actuator)
    implementation(libs.org.springframework.boot.spring.boot.starter.thymeleaf)
    implementation(libs.org.springframework.boot.spring.boot.starter.web)

    implementation(libs.com.github.ben.manes.caffeine.caffeine)
    implementation(libs.com.github.kkuegler.human.readable.ids.java)

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation(libs.com.tngtech.archunit.archunit.junit5)
}

group = "com.jitterted"
version = "0.0.3"
description = "Format Hero"
java.sourceCompatibility = JavaVersion.VERSION_21

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<Javadoc>() {
    options.encoding = "UTF-8"
}
