package Testy;

import static org.junit.jupiter.api.Assertions.*;
import Svet.SvetovaMapa;
import org.junit.jupiter.api.Test;

public class SvetovaMapaTest {

    @Test

    public void testSvetovaMapa() {
        SvetovaMapa m = new SvetovaMapa();
        assertTrue(m.nacistMapu());
    }
}
