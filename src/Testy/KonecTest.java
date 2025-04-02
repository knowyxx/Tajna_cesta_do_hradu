package Testy;

import static org.junit.jupiter.api.Assertions.*;
import Prikazy.Konec;
import org.junit.jupiter.api.Test;

public class KonecTest {

    @Test

    public void execute(){
        Konec konec = new Konec();
        assertEquals("Okay.", konec.execute());
        assertTrue(konec.exit());
    }
}
