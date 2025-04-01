package Prikazy;

import Svet.SvetovaMapa;
import Svet.Veci;
import postavy.Hrac;
import postavy.Montra;
import postavy.NPC;

import java.util.ArrayList;
import java.util.Scanner;

public class Batoh implements Prikazy{

    private ArrayList<Veci> batoh = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private SvetovaMapa mapa;

    @Override
    public String execute() {
        System.out.println("Copa chcete delat s batohem?");


        String odpoved = scanner.next();
        switch (odpoved.toLowerCase()) {
            case "vezmi":
                System.out.println("Co chcete vzit?");
                String vzitVec = scanner.next();
                return vezmi(vzitVec);
//                if (mapa.getVecy().containsKey(mapa.getAktualniLokace().getID())){
//                    if (vzitVec.equalsIgnoreCase(mapa.getVecy().get(mapa.getAktualniLokace().getID()).getJmeno())){
//                        return vezmi(mapa.getVecy().get(mapa.getAktualniLokace().getID()));
//                    }
//                }
            case "poloz":
                System.out.println("Co chcete polozit?");
                String polozVec = scanner.next();
                return polozit(polozVec);
            default: return "vezmi/poloz";
        }
    }

    public String vezmi(String vec){
        if (mapa.getVecy().containsKey(mapa.getAktualniLokace().getID())) {
            if (vec.equalsIgnoreCase(mapa.getVecy().get(mapa.getAktualniLokace().getID()).getJmeno())) {
                if (mapa.getHrac().getBatoh().getBatoh().size()<6) {
                    mapa.getHrac().getBatoh().getBatoh().add(mapa.getVecy().get(mapa.getAktualniLokace().getID()));
                    //mapa.getVecy().remove(mapa.getAktualniLokace().getID());
                    mapa.updatovaniVeci(mapa.getVecy().get(mapa.getAktualniLokace().getID()));
                    System.out.println(vec+" bylo pridany do batohu");
                }else {
                    System.out.println( "Plny batoh.");
                }
            }else System.out.println("Vec neni v mistnosti");
        }
        return "";
    }

    public String polozit(String jmeno){
        for (int i = 0; i < mapa.getHrac().getBatoh().getBatoh().size(); i++) {
            if (jmeno.equalsIgnoreCase(mapa.getHrac().getBatoh().getBatoh().get(i).getJmeno())){
                mapa.updatovaniVeci(mapa.getHrac().getBatoh().getBatoh().get(i));
                mapa.getHrac().getBatoh().getBatoh().remove(i);
                System.out.println("Uspesne odstraneno!");
                System.out.println(mapa.getVecy());
                //mapa.getAktualniLokace().;//udelat metodu v svetovy mape na polozeni veci(updatovani mapy)
                //return "Uspesne odstraneno!";
            }else System.out.println("Vec nemate v batohu.");
        }
        //return "Vec nemate v batohu.";
        return "";
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
        return mapa;
    }

    @Override
    public void setMonstra(Montra montra) {
    }

    @Override
    public void SetBatoh(Batoh batoh) {
        this.batoh = mapa.getHrac().getBatoh().getBatoh();
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

    public ArrayList<Veci> getBatoh() {
        return batoh;
    }

}
