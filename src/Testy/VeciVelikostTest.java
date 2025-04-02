package Testy;

import Svet.SvetovaMapa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VeciVelikostTest {

    @Test

    public void testVeciVelikost() {
        SvetovaMapa mapa = new SvetovaMapa();
        mapa.nacistMapu();
        assertEquals(8,mapa.getVecy().size());
    }
}
