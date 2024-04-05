package app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WhiteboxAppTest {

    @Test
    void testApp() {
        assertEquals("app", App.moduleName());
    }
}
