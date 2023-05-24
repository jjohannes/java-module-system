package my.product.service;

import my.product.data.Message;
import my.product.service.impl.ServiceImpl;

public interface Service {

    static Service create() {
        return new ServiceImpl();
    }

    void queue(Message m);

    boolean process();
}
