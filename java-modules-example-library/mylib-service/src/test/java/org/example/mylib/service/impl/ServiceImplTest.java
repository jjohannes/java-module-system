package org.example.mylib.service.impl;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceImplTest {

    @Test
    void testDebugMessage() {
        assertEquals("org.example.mylib.service >> Nothing to do", new ServiceImpl().debugMessage());
    }
}
