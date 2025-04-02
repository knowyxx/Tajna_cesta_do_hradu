package Testy;

import static org.junit.jupiter.api.Assertions.*;
import Prikazy.Pohyb;
import Svet.SvetovaMapa;
import org.junit.jupiter.api.Test;

public class PohybTest {

    @Test

    void testNapoveda() {
        SvetovaMapa mapa = new SvetovaMapa();
        mapa.nacistMapu();
        assertEquals("Nemuzete jit na jih", mapa.pohyb("jih"));
//        Pohyb pohyb = new Pohyb();
//        assertEquals("Kam chcete jit: sever, vychod, jih, zapad",pohyb.execute());
    }
}
