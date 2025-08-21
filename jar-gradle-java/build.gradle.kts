import org.gradle.api.tasks.bundling.Jar

plugins {
  id("java")
  java
  application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

java {
  toolchain {
    languageVersion.set(JavaLanguageVersion.of(24))
  }
}

dependencies {
  // https://mvnrepository.com/artifact/com.google.guava/guava
  implementation("com.google.guava:guava:33.4.8-jre")
  testImplementation(platform("org.junit:junit-bom:5.10.0"))
  testImplementation("org.junit.jupiter:junit-jupiter")
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.register<Jar>("myJar") {
  from(sourceSets.main.get().output)
  archiveFileName.set("my-jar.jar")
  manifest {
    attributes["Main-Class"] = "org.example.Main"
  }
}

tasks.test {
  useJUnitPlatform()
}