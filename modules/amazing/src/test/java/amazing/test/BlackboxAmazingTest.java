package amazing.test;

import amazing.AmazingService;
import org.junit.jupiter.api.Test;

public class BlackboxAmazingTest {

    @Test
    void testService() {
        AmazingService.DEFAULT.compute();
    }
}
