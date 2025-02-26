package Svet;

import java.util.Arrays;

public class Lokace {

    private String jmeno;
    private int ID;
    private int[] lokace;

    public Lokace() {

    }

    public Lokace(String jmeno, int ID, int[] lokace) {
        this.jmeno = jmeno;
        this.ID = ID;
        this.lokace = new int[4];//zeptat se co tohlecto je
        for (int i = 0; i < lokace.length; i++) {
            this.lokace[i] = Integer.parseInt(toString(lokace[i]));
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
}
