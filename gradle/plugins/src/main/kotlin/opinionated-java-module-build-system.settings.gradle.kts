plugins {
    id("com.gradle.develocity")
}

layout.rootDirectory.dir("modules").asFile.listFiles()?.forEach { folder ->
    if (File(folder, "src/main/java/module-info.java").exists()) {
        include(folder.name)
        project(":${folder.name}").projectDir = folder
    }
}

gradle.beforeProject {
    layout.buildDirectory.set(settings.layout.rootDirectory.dir("build").dir(name))
    val mainClassName = providers.fileContents(layout.projectDirectory.file("main-class.txt")).asText

    when {
        this == rootProject -> {
            apply(plugin = "com.autonomousapps.dependency-analysis")
        }
        name == "versions" ->  {
            apply(plugin = "java-platform")
            apply(plugin = "org.gradlex.java-module-versions")
        }
        mainClassName.isPresent -> {
            apply(plugin = "metadata-patch")
            apply(plugin = "application")
            apply(plugin = "java-module")
            extensions.configure<JavaApplication> {
                mainClass = mainClassName.get()
                mainModule = mainClassName.get().substring(0, mainClassName.get().lastIndexOf('.'))
            }
        }
        else -> {
            apply(plugin = "metadata-patch")
            apply(plugin = "java-library")
            apply(plugin = "java-module")
        }
    }
}

include(":versions")
project(":versions").projectDir = file("gradle/versions")

dependencyResolutionManagement {
    repositories.mavenCentral() // Repository to find 3rd party modules
}

develocity {
    buildScan {
        termsOfUseUrl = "https://gradle.com/help/legal-terms-of-use"
        termsOfUseAgree = "yes"
    }
}

buildCache {
    remote<HttpBuildCache> {
        url = uri("https://cache.onepiece.software/cache")
        if (providers.environmentVariable("CI").getOrElse("false").toBoolean()) {
            isPush = true;
            credentials.username = providers.environmentVariable("BUILD_CACHE_USER").get()
            credentials.password = providers.environmentVariable("BUILD_CACHE_PWD").get()
        }
    }
}
