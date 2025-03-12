package Prikazy;

public class Konec implements Prikazy{

    @Override
    public String execute() {
        return "Okay";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
