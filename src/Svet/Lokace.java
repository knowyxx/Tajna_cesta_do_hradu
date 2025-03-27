package Svet;

import java.util.Arrays;

public class Lokace {

    private String jmeno;
    private int ID;
    private int[] lokace;

    public Lokace() {

    }

    public Lokace(String jmeno, int ID, String[] lokace) {
        this.jmeno = jmeno;
        this.ID = ID;
        this.lokace = new int[4];
        for (int i = 0; i < lokace.length; i++) {
            this.lokace[i] = Integer.parseInt((lokace[i]));
        }
    }

    private String toString(int i) {
        return "";
    }

    @Override
    public String toString() {
        return "Lokace{" +
                "jmeno='" + jmeno + '\'' +
                ", ID=" + ID +
                ", lokace=" + Arrays.toString(lokace) +
                '}';
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int[] getLokace() {
        return lokace;
    }

    public void setLokace(int[] lokace) {
        this.lokace = lokace;
    }
}
