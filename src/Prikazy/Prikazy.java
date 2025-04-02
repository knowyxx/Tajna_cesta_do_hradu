package Prikazy;

import Svet.SvetovaMapa;
import postavy.Hrac;
import postavy.Montra;
import postavy.NPC;

public interface Prikazy {
    /**
     * execute() = odehrani prikazu
     * exit() = jestli uzivatel chce ukoncit hru.
     * setSvet(SvetovaMapa mapa) = nastaveni mapy.
     * getSvet() = vraci Svetovou mapu;
     * GetMonstra(Montra montra) = vraci monstra.
     * SetBatoh(Batoh batoh) = nastaveni batohu
     * setNPC(NPC npc) = nastaveni NPC.
     * setHrac(Hrac hrac) = nastaveni hrace.
     * getHrac() = vraci hrace.
     * getMontra() = vraci monstra.
     * @return
     */
    String execute();
    boolean exit();
    void setSvet(SvetovaMapa mapa);
    SvetovaMapa getSvet();
    void setMonstra(Montra montra);
    void SetBatoh(Batoh batoh);
    void setNPC(NPC npc);
    void setHrac(Hrac hrac);
    Hrac getHrac();
    Montra getMontra();
}
