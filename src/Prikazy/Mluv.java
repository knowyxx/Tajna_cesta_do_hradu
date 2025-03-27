package Prikazy;

import Svet.SvetovaMapa;
import postavy.Hrac;
import postavy.Montra;
import postavy.NPC;

import java.util.Scanner;

public class Mluv implements Prikazy {

    private Scanner scanner = new Scanner(System.in);
    private SvetovaMapa mapa;
    private NPC npc;
    @Override
    public String execute() {
        System.out.println("S kym chcete mluvit?");
        String osoba = scanner.next();

        if (npc.getNpc().containsKey(mapa.getAktualniLokace().getID())){
            if (osoba.equalsIgnoreCase(npc.getJmeno())) {
                return npc.getNpc().get(mapa.getAktualniLokace().getID()).getText();
            }
            return "Osoba neni v mistnosti";
        }
        return null;
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public void setSvet(SvetovaMapa mapa) {
        this.mapa = mapa;
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
        this.npc = npc;
    }

    @Override
    public void setHrac(Hrac hrac) {

    }

    @Override
    public void SetBatoh(Batoh batoh) {

    }
}
