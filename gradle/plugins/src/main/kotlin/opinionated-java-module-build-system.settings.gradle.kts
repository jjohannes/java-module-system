plugins {
    id("com.gradle.develocity")
}

layout.rootDirectory.dir("modules").asFile.listFiles()?.forEach { folder ->
    if (File(folder, "src/main/java/module-info.java").exists()) {
        include(folder.name)
        project(":${folder.name}").projectDir = folder
    }
}

val mainClassName = "app.App"

gradle.beforeProject {
    when {
        this == rootProject -> {
            apply(plugin = "com.autonomousapps.dependency-analysis")
        }
        name == "versions" ->  {
            apply(plugin = "java-platform")
            apply(plugin = "org.gradlex.java-module-versions")
        }
        layout.projectDirectory.file("src/main/java/${mainClassName.replace('.', '/')}.java").asFile.exists() -> {
            apply(plugin = "metadata-patch")
            apply(plugin = "application")
            apply(plugin = "java-module")
            extensions.configure<JavaApplication> {
                mainClass = mainClassName
                mainModule = mainClassName.substring(0, mainClassName.lastIndexOf('.'))
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

develocity {
    buildScan {
        termsOfUseUrl = "https://gradle.com/help/legal-terms-of-use"
        termsOfUseAgree = "yes"
    }
}

buildCache {
    remote<HttpBuildCache> {
        url = uri("https://gradle.onepiece.software:5071/cache")
        if (providers.environmentVariable("CI").getOrElse("false").toBoolean()) {
            isPush = true;
            credentials.username = providers.environmentVariable("BUILD_CACHE_USER").get()
            credentials.password = providers.environmentVariable("BUILD_CACHE_PWD").get()
        }
    }
}
