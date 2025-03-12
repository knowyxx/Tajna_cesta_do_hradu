package Prikazy;

import Svet.SvetovaMapa;
import Svet.Veci;

import java.util.ArrayList;
import java.util.Scanner;

public class Batoh implements Prikazy{

    private ArrayList<Veci> batoh = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String execute() {
        System.out.println("Copa chcete delat s batohem?");
        Veci veci = new Veci();
        SvetovaMapa mapa = new SvetovaMapa();
        String odpoved = scanner.next();
        switch (odpoved){
            case "vezmi":
                System.out.println("Co chcete vzit?");
                String vzitVec = scanner.next();
                for (int i = 0; i < mapa.getVeci().size(); i++) {
                    if (mapa.getVeci().get(i).getJmeno().equalsIgnoreCase(vzitVec)){
                        if (mapa.getVeci().get(i).getID()==mapa.getAktualniLokace().getID()){
                            batoh.add(mapa.getVeci().get(i));
                            return vzitVec + " pridany do batohu";
                        }else return "Vec neni ve vasi lokaci.";
                    }else return "Vec spatne napsany.";
                }

            case "poloz":
                System.out.println("Co chcete polozit?");
                String polozVec = scanner.next();
                for (int i = 0; i < batoh.size(); i++) {
                    if (polozVec.equalsIgnoreCase(batoh.get(i).getJmeno())){
                        batoh.remove(i);
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

    public boolean vezmi(Veci vec){
        if (batoh.size()<6) {
            batoh.add(vec);
            return true;
        }else {
            System.out.println( "Plny batoh.");
            return false;
        }

    }

    public String polozit(String jmeno){
        for (int i = 0; i < batoh.size(); i++) {
            if (jmeno.equalsIgnoreCase(batoh.get(i).getJmeno())){
                batoh.remove(i);
                return "Uspesne odstraneno!";
            }else{
                return "Vec nemate v batohu.";

            }
        }
        return null;
    }

    public ArrayList<Veci> getBatoh() {
        return batoh;
    }

    public void setBatoh(ArrayList<Veci> batoh) {
        this.batoh = batoh;
    }
}
