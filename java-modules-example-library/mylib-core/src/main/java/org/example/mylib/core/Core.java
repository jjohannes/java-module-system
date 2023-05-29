package org.example.mylib.core;

import jakarta.annotation.Nonnull;
import org.example.mylib.service.Service;

import java.util.List;

public class Core {

    public static void useLib(@Nonnull List<String> params) {
        System.out.println(Core.class.getModule().getName() + " >> running core module");
        Service.create().process();
    }
}
