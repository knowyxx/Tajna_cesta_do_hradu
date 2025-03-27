package Prikazy;

import Svet.Lokace;
import Svet.SvetovaMapa;
import postavy.Hrac;
import postavy.Montra;
import postavy.NPC;

import java.util.Scanner;

public class Pohyb implements Prikazy {

    private Scanner scanner = new Scanner(System.in);
    private SvetovaMapa mapa;

    @Override
    public String execute() {
        System.out.println("Kam chcete jit: sever, vychod, jih, zapad");
        String smer = scanner.next();
        return mapa.pohyb(smer.toLowerCase());
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

    }

    @Override
    public void setHrac(Hrac hrac) {

    }

    @Override
    public void SetBatoh(Batoh batoh) {

    }
}
