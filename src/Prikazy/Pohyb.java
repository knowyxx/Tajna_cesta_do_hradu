package Prikazy;

import Svet.SvetovaMapa;
import postavy.Hrac;
import postavy.Montra;
import postavy.NPC;

import java.util.Scanner;

/**
 * Trida pro pohyb.
 */
public class Pohyb implements Prikazy {

    /**
     * Vlastnosti tridy pro metody.
     */
    private Scanner scanner = new Scanner(System.in);
    private SvetovaMapa mapa;

    /**
     * Prikaz ktery uzivatele pohne do jine mistnosti, jestli nejsou(zabil) monstra v mistnosti.
     * @return
     */
    @Override
    public String execute() {
        if (!mapa.getMontras().containsKey(mapa.getAktualniLokace().getID())){
            System.out.println("Kam chcete jit: sever, vychod, jih, zapad");
            String smer = scanner.next();
            return mapa.pohyb(smer.toLowerCase());
        } else {
            return "Nesmite se pohnout, kdyz mate monstrum v mistnosti.";
        }
    }

    /**
     * Dalsi interface metody.
     * @return
     */
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
