package org.example.mylib.service;

import org.example.mylib.data.Message;
import org.example.mylib.service.impl.ServiceImpl;

public interface Service {

    static Service create() {
        return new ServiceImpl();
    }

    void queue(Message m);

    boolean process();
}
