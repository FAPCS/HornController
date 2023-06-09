import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.0"
    application

    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "me.fapcs"
version = "0.0.0"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    api("me.fapcs:Shared:0.4.0")
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "17"
        }
    }

    build {
        dependsOn("shadowJar")
    }

    shadowJar {
        archiveClassifier.set("")
    }
}

application {
    mainClass.set("me.fapcs.small_matrix_controller.SmallMatrixController")
}