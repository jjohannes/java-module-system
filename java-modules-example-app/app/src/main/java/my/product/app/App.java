package my.product.app;

import jakarta.annotation.Nonnull;
import my.product.service.Service;

public class App {

    public static void main(@Nonnull String[] args) {
        System.out.println(App.class.getModule().getName() + " >> running app");
        Service.create().process();
    }
}
