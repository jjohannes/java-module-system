// Tweak the Java building process (Java version, encoding, test memory settings, ...)
plugins {
    id("java")
    id("org.gradlex.java-module-testing")
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(
        providers.fileContents(isolated.rootProject.projectDirectory
            .file("gradle/java-version.txt")).asText.get().trim()
    )
}
tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}
tasks.withType<Test>().configureEach {
    maxParallelForks = 4
    maxHeapSize = "1g"
}
