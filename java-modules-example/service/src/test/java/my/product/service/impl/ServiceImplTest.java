package my.product.service.impl;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceImplTest {

    @Test
    void testDebugMessage() {
        assertEquals("my.product.service >> Nothing to do", new ServiceImpl().debugMessage());
    }
}
