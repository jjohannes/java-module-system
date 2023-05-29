package my.product.data;

import my.product.data.impl.MessageImpl;

public interface Message {

    static Message create(String m) {
        return new MessageImpl(m);
    }

    String get();
}
