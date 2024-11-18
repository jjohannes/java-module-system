plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation("com.autonomousapps:dependency-analysis-gradle-plugin:2.4.2")
    implementation("com.gradle:develocity-gradle-plugin:3.17.5")
    implementation("org.gradlex:extra-java-module-info:1.9")
    implementation("org.gradlex:java-module-dependencies:1.8")
    implementation("org.gradlex:java-module-packaging:1.0")
    implementation("org.gradlex:java-module-testing:1.5")
    implementation("org.gradlex:jvm-dependency-conflict-resolution:2.1.2")
}
