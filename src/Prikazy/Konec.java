package Prikazy;

import Svet.SvetovaMapa;
import postavy.Hrac;
import postavy.Montra;
import postavy.NPC;

public class Konec implements Prikazy{

    @Override
    public String execute() {
        return "Okay";
    }

    @Override
    public boolean exit() {
        return true;
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
    public Hrac getHrac() {
        return null;
    }

    @Override
    public Montra getMontra() {
        return null;
    }

    @Override
    public void SetBatoh(Batoh batoh) {

    }
}
