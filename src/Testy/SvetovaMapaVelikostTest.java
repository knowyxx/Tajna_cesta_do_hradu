package Testy;

import Svet.SvetovaMapa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SvetovaMapaVelikostTest {

    @Test
    void SvetovaMapaVelikostTest() {
        SvetovaMapa svetova = new SvetovaMapa();
        svetova.nacistMapu();
        assertEquals(8, svetova.getSvet().size());
    }
}