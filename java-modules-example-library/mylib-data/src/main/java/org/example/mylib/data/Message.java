package org.example.mylib.data;

import org.example.mylib.data.impl.MessageImpl;

public interface Message {

    static Message create(String m) {
        return new MessageImpl(m);
    }

    String get();
}
