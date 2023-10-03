plugins {
    kotlin("jvm") version "1.9.0"
    application
}

group = "me.skillissue"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {// https://mvnrepository.com/artifact/io.ktor/ktor-client-core-jvm
    implementation("io.ktor:ktor-client-core-jvm:2.3.4")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}