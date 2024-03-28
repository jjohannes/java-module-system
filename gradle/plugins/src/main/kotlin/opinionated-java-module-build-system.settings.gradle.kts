layout.rootDirectory.dir("modules").asFile.listFiles()?.forEach { folder ->
    if (File(folder, "src/main/java/module-info.java").exists()) {
        include(folder.name)
        project(":${folder.name}").projectDir = folder
    }
}

val mainClassName = "app.App"

gradle.beforeProject {
    when {
        name == "versions" ->  {
            apply(plugin = "java-platform")
            apply(plugin = "org.gradlex.java-module-versions")
        }
        layout.projectDirectory.file("src/main/java/${mainClassName.replace('.', '/')}.java").asFile.exists() -> {
            apply(plugin = "application")
            apply(plugin = "java-module")
            extensions.configure<JavaApplication> {
                mainClass = mainClassName
                mainModule = mainClassName.substring(0, mainClassName.lastIndexOf('.'))
            }
        }
        else -> {
            apply(plugin = "java-library")
            apply(plugin = "java-module")
        }
    }
}

include(":versions")
project(":versions").projectDir = file("gradle/versions")
