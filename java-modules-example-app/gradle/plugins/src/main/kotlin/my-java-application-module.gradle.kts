plugins {
    id("application")
    id("my-java-module")
}

application {
    mainModule.set("my.product.app")
    mainClass.set("my.product.app.App")
}