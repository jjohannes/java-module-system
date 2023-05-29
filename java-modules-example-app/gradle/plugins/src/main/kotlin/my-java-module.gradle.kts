plugins {
    id("java-library")
    id("org.gradlex.extra-java-module-info")
    id("org.gradlex.java-module-dependencies")
    id("org.gradlex.java-module-testing")
}

group = "my.product"
version = "1.0"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

javaModuleDependencies {
    moduleNameToGA.put("org.apache.commons.lang3",
        "org.apache.commons:commons-lang3")
}

extraJavaModuleInfo {
    module("org.apache.commons:commons-lang3",
        "org.apache.commons.lang3") { exportAllPackages() }
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