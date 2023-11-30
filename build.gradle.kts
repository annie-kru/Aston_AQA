plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.10.0")
    implementation("org.seleniumhq.selenium:selenium-java:2.41.0")
}

tasks.test {
    useJUnitPlatform()
}