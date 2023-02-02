plugins {
    id("my.product.java-module-rules")
    id("java")
    id("org.gradlex.java-module-testing")
}

java.toolchain.languageVersion.set(JavaLanguageVersion.of(11))

dependencies {
    implementation(platform(project(":platform")))
    testImplementation(platform(project(":platform")))
}

javaModuleTesting.whitebox(testing.suites.getByName<JvmTestSuite>("test") {
    useJUnitJupiter()
}) {
    requires.add("org.junit.jupiter.api")
    opensTo.add("org.junit.platform.commons")
}

// javaModuleTesting.blackbox(testing.suites["test"])

configurations.testCompileOnly.get().extendsFrom(
        configurations.compileOnly.get()
)
