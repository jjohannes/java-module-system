package my.product.service.test.functional;


import my.product.data.Message;
import my.product.service.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ServiceFunctionalTest {

    private Service s;

    @BeforeEach
    void setup() {
        s = Service.create();
    }

    @Test
    void testEmpty() {
        assertFalse(s.process());
    }

    @Test
    void testFull() {
        s.queue(Message.create("Testing"));
        assertTrue(s.process());
        assertFalse(s.process());
    }
}
