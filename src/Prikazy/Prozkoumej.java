package Prikazy;

import Svet.SvetovaMapa;
import postavy.Hrac;
import postavy.Montra;
import postavy.NPC;

import java.util.Scanner;

/**
 * Trida pro prozkoumani mistnosti ci veci.
 */
public class Prozkoumej implements Prikazy {

    /**
     * Vlastnosti tridy pro metody.
     */
    private Scanner scanner = new Scanner(System.in);
    private SvetovaMapa mapa;

    /**
     * Prikaz ktery vypise aktualni mistnosti, veci, monstra a NPC nebo jmeno, utok a popis veci.
     * @return
     */
    @Override
    public String execute() {
        System.out.println("Co chcete prozkoumat?");
        String rozhodnuti = scanner.next();
        if (rozhodnuti.equalsIgnoreCase("mistnost")) {
            System.out.println("Mistnost kde se nachazite: "+mapa.getAktualniLokace().getJmeno());
            if (mapa.getVecy().containsKey(mapa.getAktualniLokace().getID())) {
                System.out.println("Veci na zemi: "+mapa.getVecy().get(mapa.getAktualniLokace().getID()).getJmeno());
            }
            if (mapa.getMontras().containsKey(mapa.getAktualniLokace().getID())){
                System.out.println("Monstra v mistnosti: "+mapa.getMontras().get(mapa.getAktualniLokace().getID()).getJmeno());
            }
            if (mapa.getNpcs().containsKey(mapa.getAktualniLokace().getID())){
                System.out.println("NPC v mistnosti: "+mapa.getNpcs().get(mapa.getAktualniLokace().getID()).getJmeno());
            }
        } else for (int i = 0; i < mapa.getBatoh().getBatoh().size(); i++) {
            if (rozhodnuti.equalsIgnoreCase(mapa.getBatoh().getBatoh().get(i).getJmeno())) {
                return "Vec: "+mapa.getBatoh().getBatoh().get(i).getJmeno()+"\n"+
                        "Sila: "+ mapa.getBatoh().getBatoh().get(i).getSila()+"\n"+
                        "Popis: "+mapa.getBatoh().getBatoh().get(i).getPopis();
            }else return "vec nemate v batohu.";
        }
        return "";
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
