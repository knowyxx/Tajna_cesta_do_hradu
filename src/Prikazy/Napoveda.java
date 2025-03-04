package Prikazy;

import Svet.Lokace;

public class Napoveda implements Prikazy{

    private Lokace aktualniLokace = new Lokace();

    @Override
    public String execute() {
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
