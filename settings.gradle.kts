pluginManagement {
    includeBuild("gradle/plugins")
}
plugins {
    id("build-system")
}
rootPlugins {
    id("dependency-analysis")
}

javaModules {
    // Location of own modules
    directory("modules") {
        plugin("java-module")
        group = "org.example"
        module("app") { plugin("application") }
    }
    // Versions of third party modules
    versions("gradle/versions")
}

dependencyResolutionManagement {
    //Locations of third party modules
    repositories {
        mavenCentral()
    }
}
