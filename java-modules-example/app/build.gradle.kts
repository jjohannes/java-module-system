plugins {
    id("my.product.java-application-module")
}

application {
    mainModule.set("my.product.app")
    mainClass.set("my.product.app.App")
}