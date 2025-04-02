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

    /**
     *Prikaz ktery nacte text z NPC
     * @return
     */
    @Override
    public String execute() {
        if (mapa.getNpcs().containsKey(mapa.getAktualniLokace().getID())){
            System.out.println("S kym chcete mluvit?");
            String osoba = scanner.next();
            if (osoba.equalsIgnoreCase(npc.getJmeno())) {
                return mapa.getNpcs().get(mapa.getAktualniLokace().getID()).getText();
            }else return "Osoba neni v mistnosti.";
        }else return "Nidko v mistnosti.";
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
        this.npc = npc;
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
