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
                for (int i = 0; i < mapa.getVecy().size(); i++) {
                    if (mapa.getVecy().get(i).getJmeno().equalsIgnoreCase(vzitVec)) {
                        if (mapa.getVecy().get(i).getID() == mapa.getAktualniLokace().getID()) {
                            vezmi(mapa.getVecy().get(i));
                            return vzitVec + " pridany do batohu";
                        } else System.out.println( "Vec neni ve vasi lokaci.");
                    } else System.out.println( "Vec spatne napsany.");
                }


            case "poloz":
                System.out.println("Co chcete polozit?");
                String polozVec = scanner.next();
                for (int i = 0; i < batoh.size(); i++) {
                    if (polozVec.equalsIgnoreCase(batoh.get(i).getJmeno())){
                        polozit(mapa.getVecy().remove(i).getJmeno());
                        return "Polozili jste "+polozVec;
                    }
                }
            default: return "vezmi/poloz";
        }
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
        this.batoh = batoh.getBatoh();

    }

    @Override
    public void setNPC(NPC npc) {

    }

    @Override
    public void setHrac(Hrac hrac) {

    }



    public boolean vezmi(Veci vec){
        if (batoh.size()<6) {
            batoh.add(vec);
            return true;
        }else {
            System.out.println( "Plny batoh.");
            return false;
        }

    }

    public boolean polozit(String jmeno){
        for (int i = 0; i < batoh.size(); i++) {
            if (jmeno.equalsIgnoreCase(batoh.get(i).getJmeno())){
                batoh.get(i).setID(mapa.getAktualniLokace().getID());
                batoh.remove(i);
                System.out.println("Uspesne odstraneno!");
                return true;
            }
        }
        System.out.println("Vec nemate v batohu.");
        return false;
    }

    public ArrayList<Veci> getBatoh() {
        return batoh;
    }

}
