package Prikazy;

import Svet.Lokace;
import Svet.SvetovaMapa;
import postavy.Hrac;
import postavy.Montra;

import java.util.Scanner;

public class Boj implements Prikazy{

    private Scanner scanner = new Scanner(System.in);


    @Override
    public String execute() {
        SvetovaMapa mapa = new SvetovaMapa();
        Montra montra = new Montra();
        System.out.println("Na koho chcete zautocit?");
        String jmeno = scanner.next();
        if (jmeno.equalsIgnoreCase(montra.getMonstra().get(mapa.getAktualniLokace().getID()).getJmeno())) {
            boj();
        }
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }

    public String boj (){
        Hrac hrac = new Hrac();
        Montra montra = new Montra();
        Batoh batoh = new Batoh();
        String viteznik="";
        System.out.println("Napiste utok abyste zautocili.");
        while (hrac.isJeZivy() || montra.isJeZivy()){
            String odpoved = scanner.next();
            if (odpoved.equalsIgnoreCase("utok")){
                System.out.println("A s cim chcete uderit?");
                odpoved = scanner.next();
                for (int i = 0; i < batoh.getBatoh().size(); i++) {
                    if (batoh.getBatoh().get(i).getVec().getJmeno().equalsIgnoreCase(odpoved)){
                        montra.protivnikUtok(hrac.getUtok(), batoh.getBatoh().get(i).getVec().getSila());
                    }
                }
            }else System.out.println(montra.getJmeno()+": Ha ty na me nebudes utocit?");
            hrac.protivnikUtok(montra.getUtok());
            hrac.isJeZivy();
            montra.isJeZivy();
            if (hrac.isJeZivy()&&!montra.isJeZivy()){
                System.out.println("Zvitezili jste!");
                viteznik = "hrac";
            }
            if (!hrac.isJeZivy()&&montra.isJeZivy()){
                System.out.println("Prohrali jste...");
                viteznik = montra.getJmeno();
            }
        }
        return viteznik;
    }
}
