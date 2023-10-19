plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.9.10"
    id("org.danilopianini.git-sensitive-semantic-versioning-gradle-plugin") version "1.1.14"
    id("org.jetbrains.dokka") version "1.9.0"
    id ("org.danilopianini.publish-on-central") version "5.0.15"
    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

group = "io.github.andreagiulianelli"

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    // Use the Kotlin JDK 8 standard library.
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    // Use the Kotlin test library.
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    // Use the Kotlin JUnit integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

application {
    mainClass.set("devops.AppKt")
}

publishOnCentral {
    projectUrl.set("https://github.com/AndreaGiulianelli/devops-practice")
    scmConnection.set("https://github.com/AndreaGiulianelli/devops-practice")
}

publishing {
    publications {
        withType<MavenPublication> {
            pom {
                developers {
                    developer {
                        name.set("Andrea Giulianelli")
                        url.set("https://github.com/AndreaGiulianelli")
                    }
                }
            }
        }
    }
}
signing {
    val signingKey: String? by project
    val signingPassword: String? by project
    useInMemoryPgpKeys(signingKey, signingPassword)
}
