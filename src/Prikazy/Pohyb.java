package Prikazy;

import Svet.Lokace;
import Svet.SvetovaMapa;

import java.util.Scanner;

public class Pohyb implements Prikazy {

    private Scanner scanner = new Scanner(System.in);
    private Lokace akutalniLokace = new Lokace();
    private SvetovaMapa svet = new SvetovaMapa();

    @Override
    public String execute() {
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
