plugins {
    id("java")
}

// Tweak the Java building process (Java version, encoding, test memory settings, ...)
java {
    toolchain.languageVersion = JavaLanguageVersion.of(21)
}
tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}
tasks.withType<Test>().configureEach {
    maxParallelForks = 4
    maxHeapSize = "1g"
}
