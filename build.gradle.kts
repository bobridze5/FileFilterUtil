plugins {
    id("java")
    id("application")
    id("com.gradleup.shadow") version "9.3.1"
}

group = "ctf.alsaev"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("ctf.alsaev.Main")
}


repositories {
    mavenCentral()
}

dependencies {
    implementation("com.beust:jcommander:1.82")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks.jar {
    enabled = false
}

tasks.shadowJar {
    archiveFileName.set("util.jar")
}

tasks.build {
    dependsOn(tasks.shadowJar)
}