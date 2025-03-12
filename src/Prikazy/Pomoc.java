package Prikazy;

public class Pomoc implements Prikazy {
    @Override
    public String execute() {
        return "Tady je list vsech prikazu dostupnych:" +"\n"+
                "Batoh" +"\n"+
                "Boj" +"\n"+
                "Konec" +"\n"+
                "Mluv" +"\n"+
                "Napoveda" +"\n"+
                "Pohyb" +"\n"+
                "Pomoc" +"\n"+
                "Prozkoumej";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
