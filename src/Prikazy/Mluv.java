package Prikazy;

import Svet.SvetovaMapa;
import postavy.NPC;

import java.util.Scanner;

public class Mluv implements Prikazy {

    Scanner scanner = new Scanner(System.in);

    @Override
    public String execute() {
        SvetovaMapa mapa = new SvetovaMapa();
        NPC npc = new NPC();
        System.out.println("S kym chcete mluvit?");
        String osoba = scanner.next();
        if (osoba.equalsIgnoreCase(npc.getJmeno())&&mapa.getAktualniLokace().getID()==7){
            return npc.konverzace();
        }
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
