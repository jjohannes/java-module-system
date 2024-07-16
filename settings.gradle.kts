pluginManagement { includeBuild("gradle/plugins") }
plugins {
    id("build-performance")
    id("module-locations")
}
rootPlugins {
    id("dependency-analysis")
}
