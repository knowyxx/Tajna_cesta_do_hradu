package Prikazy;

import Svet.SvetovaMapa;
import postavy.Hrac;
import postavy.Montra;
import postavy.NPC;

public interface Prikazy {
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
