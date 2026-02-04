plugins {
    kotlin("jvm") version "2.2.20"
}

group = "cn.afeibaili.mail"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("com.sun.mail:jakarta.mail:2.0.2")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}