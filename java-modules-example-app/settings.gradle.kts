pluginManagement { includeBuild("gradle/plugins") }

include("data", "service", "app")

dependencyResolutionManagement {
    repositories.mavenCentral()

    versionCatalogs.create("libs") {
        version("jakarta.annotation", "2.1.1")
        version("org.apache.commons.lang3", "3.12.0")
        version("org.junit.jupiter.api", "5.8.2")
    }
}


includeBuild(".") // https://github.com/gradle/gradle/issues/21490