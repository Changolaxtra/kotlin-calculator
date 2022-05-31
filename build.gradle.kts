import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.21"
    id("io.kotest.multiplatform") version "5.3.0"
}
group = "com.epam.cdp.caclulator"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

dependencies {
    implementation("org.junit.jupiter:junit-jupiter:5.8.2")
    testImplementation("io.kotest", "kotest-framework-datatest-jvm", "5.3.0")
    testImplementation("io.kotest", "kotest-runner-junit5-jvm", "5.3.0")
}