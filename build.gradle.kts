plugins {
    java
    application
}

group = "be.kdg"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

application {
    mainClass.set("be.kdg.legoproject.ConsoleApp")
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}

tasks.test {
    useJUnitPlatform()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}
