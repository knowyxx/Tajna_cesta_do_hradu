import Prikazy.Prikazy;
import Prikazy.Pohyb;
import Prikazy.Pomoc;
import Prikazy.Konec;

import java.util.HashMap;

public class Konzole {
    private boolean exit = false;
    private HashMap<String, Prikazy> mapa = new HashMap<>();

    public void inicializace(){
        mapa.put("pohyb", new Pohyb());
        mapa.put("pomoc", new Pomoc());
        mapa.put("konec", new Konec());
    }
}
