import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android") version "2.3.21"
}

group = "fr.skyost.bonsoir"
version = "1.0.0"

repositories {
    google()
    mavenCentral()
}

android {
    namespace = "fr.skyost.bonsoir"

    compileSdk = 37

    defaultConfig {
        minSdk = 24
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    sourceSets {
        getByName("main") {
            java.setSrcDirs(listOf("src/main/kotlin"))
        }
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true

            all {
                it.useJUnitPlatform()

                it.outputs.upToDateWhen { false }

                it.testLogging {
                    events(
                        "passed",
                        "skipped",
                        "failed",
                        "standardOut",
                        "standardError"
                    )

                    showStandardStreams = true
                }
            }
        }
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_21)
    }
}
