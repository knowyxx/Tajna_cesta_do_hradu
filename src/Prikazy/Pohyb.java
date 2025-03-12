package Prikazy;

import Svet.Lokace;
import Svet.SvetovaMapa;

import java.util.Scanner;

public class Pohyb implements Prikazy {

    private Scanner scanner = new Scanner(System.in);
    private Lokace aktualniLokace = new Lokace();
    private SvetovaMapa svet = new SvetovaMapa();

    @Override
    public String execute() {
        aktualniLokace = svet.getAktualniLokace();
        System.out.println("Kam chcete jit: sever, vychod, jih, zapad");
        String smer = scanner.next();
        System.out.println(aktualniLokace);
        switch (smer){
            case "sever":

            case "vychod":

            case "jih":

            case "zapad":

            default:
        }



        return null;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
