package Prikazy;

import Svet.SvetovaMapa;
import postavy.Hrac;
import postavy.Montra;
import postavy.NPC;

public class Pomoc implements Prikazy {
    @Override
    public String execute() {
        return "Tady je list vsech prikazu dostupnych:" +"\n"+
                "Batoh" +"\n"+
                "Boj" +"\n"+
                "Konec" +"\n"+
                "Mluv" +"\n"+
                "Napoveda" +"\n"+
                "Pohyb" +"\n"+
                "Pomoc" +"\n"+
                "Prozkoumej";
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public void setSvet(SvetovaMapa mapa) {

    }

    @Override
    public SvetovaMapa getSvet() {
        return null;
    }

    @Override
    public void setMonstra(Montra montra) {

    }

    @Override
    public void setNPC(NPC npc) {

    }

    @Override
    public void setHrac(Hrac hrac) {

    }

    @Override
    public void SetBatoh(Batoh batoh) {

    }
}
