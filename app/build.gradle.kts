plugins {
    application
    kotlin("jvm") version "2.1.20"
    id("org.jlleitschuh.gradle.ktlint") version "12.2.0"
    id("com.github.ben-manes.versions") version "0.52.0"
}

group = "hu.webhejj.statik"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    api("org.jetbrains.kotlinx:kotlinx-html-jvm:0.12.0")

    testImplementation(platform("org.junit:junit-bom:5.12.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

application {
    mainClass = "hu.webhejj.AppKt"
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

ktlint {
    version.set("1.6.0")
}
