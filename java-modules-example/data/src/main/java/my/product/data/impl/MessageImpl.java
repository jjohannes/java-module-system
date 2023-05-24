package my.product.data.impl;

import my.product.data.Message;

public class MessageImpl implements Message {

    private final String m;

    public MessageImpl(String m) {
        this.m = m;
    }

    @Override
    public String get() {
        return "[[" + getPlain() + "]]";
    }

    protected String getPlain() {
        return m;
    }
}
