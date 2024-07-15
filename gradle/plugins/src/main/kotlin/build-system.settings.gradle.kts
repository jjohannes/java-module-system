import org.gradle.caching.http.HttpBuildCache
import org.gradle.kotlin.dsl.remote

plugins {
    id("com.gradle.develocity")
    id("org.gradlex.java-module-dependencies")
}

develocity {
    buildScan {
        termsOfUseUrl = "https://gradle.com/help/legal-terms-of-use"
        termsOfUseAgree = "yes"
    }
}

buildCache {
    remote<HttpBuildCache> {
        url = uri("https://cache.onepiece.software/cache")
        if (providers.environmentVariable("CI").getOrElse("false").toBoolean()) {
            isPush = true;
            credentials.username = providers.environmentVariable("BUILD_CACHE_USER").get()
            credentials.password = providers.environmentVariable("BUILD_CACHE_PWD").get()
        }
    }
}
