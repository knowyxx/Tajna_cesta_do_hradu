package Testy;

import static org.junit.jupiter.api.Assertions.*;
import Prikazy.Pomoc;
import org.junit.jupiter.api.Test;

public class PomocTest {

    @Test

    void testPomoc() {
        Pomoc pomoc = new Pomoc();
        assertEquals("Tady je list vsech prikazu dostupnych:" +"\n"+
                "Batoh" +"\n"+
                "Boj" +"\n"+
                "Konec" +"\n"+
                "Mluv" +"\n"+
                "Napoveda" +"\n"+
                "Pohyb" +"\n"+
                "Pomoc" +"\n"+
                "Prozkoumej",pomoc.execute());
    }
}
