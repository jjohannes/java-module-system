package my.product.modulea;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SplitUtilsTest {

    @Test
    void testTokenValid() {
        assertFalse(SplitUtils.isTokenValid(""));
        assertTrue(SplitUtils.isTokenValid("a"));
    }

    @Test
    void testAddIfValid() {
        List<String> l = new ArrayList<>();
        SplitUtils.addIfValid("", l);
        assertEquals(l.size(), 0);

        SplitUtils.addIfValid("a", l);
        assertEquals(l.size(), 1);
    }

}
