plugins {
    id("java")
    id("com.gradleup.shadow") version "9.3.1"
}

group = "ctf.alsaev"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("com.beust:jcommander:1.82")
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "ctf.alsaev.Main"
    }
}

tasks.shadowJar {
    archiveFileName.set("app.jar")
}

tasks.test {
    useJUnitPlatform()
}