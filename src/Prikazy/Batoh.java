package Prikazy;

import Svet.Veci;

import java.util.ArrayList;
import java.util.Scanner;

public class Batoh implements Prikazy{

    private ArrayList<Veci> batoh = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String execute() {
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }

    public String vezmi(){
        return  null;
    }

    public String polozit(){
        return  null;
    }
}
