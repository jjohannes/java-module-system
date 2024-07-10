plugins {
    id("java")
    id("org.gradlex.jvm-dependency-conflict-resolution")
    id("org.gradlex.java-module-dependencies")
    id("org.gradlex.java-module-packaging")
    id("org.gradlex.java-module-testing")
}

version = providers.fileContents(isolated.rootProject.projectDirectory
    .file("gradle/version.txt")).asText.get().trim()

// Central version management for 3rd party modules
jvmDependencyConflicts {
    consistentResolution {
        platform(":versions")
        providesVersions(":app")
    }
}

// Multi target support and packaging
javaModulePackaging {
    target("ubuntu-22.04") {
        operatingSystem = OperatingSystemFamily.LINUX
        architecture = MachineArchitecture.X86_64
        packageTypes = listOf("deb")
    }
    target("macos-13") {
        operatingSystem = OperatingSystemFamily.MACOS
        architecture = MachineArchitecture.X86_64
        packageTypes = listOf("dmg")
    }
    target("macos-14") {
        operatingSystem = OperatingSystemFamily.MACOS
        architecture = MachineArchitecture.ARM64
        packageTypes = listOf("dmg")
    }
    target("windows-2022") {
        operatingSystem = OperatingSystemFamily.WINDOWS
        architecture = MachineArchitecture.X86_64
        packageTypes = listOf("exe")
    }

    primaryTarget(target("macos-14"))
}

// Tweak the Java building process (Java version, encoding, test memory settings, ...)
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

tasks.check {
    dependsOn(tasks.checkAllModuleInfo)
}
