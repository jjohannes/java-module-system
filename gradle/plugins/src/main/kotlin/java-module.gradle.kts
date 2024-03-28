plugins {
    id("java")
    id("org.gradlex.java-module-dependencies")
    id("org.gradlex.java-module-packaging")
}

version = "1.0"

// Repository to find 3rd party modules
repositories {
    mavenCentral()
}

// Central version management for 3rd party modules
javaModuleDependencies {
    versionsFromPlatformAndConsistentResolution(":versions", ":app")
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
    toolchain.languageVersion = JavaLanguageVersion.of(21)
}
tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}
tasks.withType<Test>().configureEach {
    maxParallelForks = 4
    maxHeapSize = "1g"
}
