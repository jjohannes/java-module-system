layout.rootDirectory.dir("modules").asFile.listFiles()?.forEach { folder ->
    if (File(folder, "src/main/java/module-info.java").exists()) {
        include(folder.name)
        project(":${folder.name}").projectDir = folder
    }
}

