pluginManagement {
    includeBuild("gradle/plugins")
}

dependencyResolutionManagement {
    repositories.mavenCentral()
}

include("app")
include("modulea")

include("platform")
