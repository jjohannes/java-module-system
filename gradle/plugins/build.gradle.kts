plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation("com.autonomousapps:dependency-analysis-gradle-plugin:1.30.0")
    implementation("org.gradlex:extra-java-module-info:1.8")
    implementation("org.gradlex:java-module-dependencies:1.6.4")
    implementation("org.gradlex:java-module-packaging:0.1")
    implementation("org.gradlex:jvm-dependency-conflict-resolution:2.0")
}
