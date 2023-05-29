plugins {
    id("java-library")
    id("maven-publish")
    id("org.gradlex.java-module-dependencies")
    id("org.gradlex.java-module-testing")
}

group = "org.example"
version = providers.fileContents(rootProject.layout.projectDirectory
    .file("version.txt")).asText.get().trim()

tasks.check {
    dependsOn(tasks.checkAllModuleInfo)
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

javaModuleDependencies {
    moduleNameToGA.put("org.apache.commons.lang3", "org.apache.commons:commons-lang3")
}

javaModuleTesting {
    whitebox(testing.suites.getByName<JvmTestSuite>("test") {
        useJUnitJupiter("")
    }) {
        requires.add("org.junit.jupiter.api")
        opensTo.add("org.junit.platform.commons")
    }
    blackbox(testing.suites.create<JvmTestSuite>("testFunctional"))
}

publishing {
    publications.create<MavenPublication>("modules").from(components["java"])

    repositories.maven(rootProject.layout.projectDirectory.dir("local-repo"))
}