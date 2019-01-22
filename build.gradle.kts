buildscript {
    val kotlinVersion: String by extra("1.3.11")

    repositories {
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}

plugins {
    id("java")
}

group = "aero.geosystems"
version = "18.1112"

tasks.withType<JavaCompile> {
    sourceCompatibility = "1.8"
    targetCompatibility = "1.8"
}

repositories {
    mavenCentral()
}
dependencies {
    compile(group="org.jetbrains", name="annotations", version="13.0")
    testCompile(group="junit", name="junit", version="4.8")
}
