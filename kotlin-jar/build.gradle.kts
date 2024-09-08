plugins {
    kotlin("jvm") version "2.0.0"
}

group = "org.script"
version = "v1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("com.google.code.gson:gson:2.11.0")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}
tasks.jar {
    manifest {
        attributes["Main-Class"] = "org.script.MainKt" // Replace with your main class
    }
    // Add all dependencies into the JAR
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}
