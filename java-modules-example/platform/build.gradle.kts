plugins {
    id("my.product.platform")
}

dependencies.constraints {
    javaModuleDependencies {
        api(gav("org.slf4j", "2.0.6"))
        api(gav("org.slf4j.simple", "2.0.6"))
        api(gav("org.slf4j.jdk14", "2.0.6"))
        api(gav("com.google.errorprone.annotations", "2.16"))
        api(gav("org.junit.jupiter.api", "5.9.2"))
    }
}
