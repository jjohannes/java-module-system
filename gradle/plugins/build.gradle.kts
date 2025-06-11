plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation("com.autonomousapps:dependency-analysis-gradle-plugin:2.18.0")
    implementation("com.gradle:develocity-gradle-plugin:4.0.2")
    implementation("org.gradlex:extra-java-module-info:1.12")
    implementation("org.gradlex:java-module-dependencies:1.9.1")
    implementation("org.gradlex:java-module-packaging:1.0.1")
    implementation("org.gradlex:java-module-testing:1.7")
    implementation("org.gradlex:jvm-dependency-conflict-resolution:2.4")
    implementation("org.gradlex:reproducible-builds:1.0")
}
