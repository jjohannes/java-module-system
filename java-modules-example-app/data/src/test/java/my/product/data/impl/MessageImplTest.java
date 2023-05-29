package my.product.data.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageImplTest {

    @Test
    void storesPlainMessageInternally() {
        MessageImpl testMessage = new MessageImpl("test message");
        assertEquals("test message", testMessage.getPlain());
    }

}
