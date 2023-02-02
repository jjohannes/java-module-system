plugins {
    id("org.gradlex.java-module-dependencies")
    id("org.gradlex.extra-java-module-info")
}

group = "my.product"

extraJavaModuleInfo {
    module("com.google.errorprone:error_prone_annotations", "com.google.errorprone.annotations") {
        exportAllPackages()
    }
}
