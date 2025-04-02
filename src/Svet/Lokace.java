package Svet;

import java.util.Arrays;

/**
 * Trida pro lokaci.
 */
public class Lokace {

    /**
     * Vlastnosti lokace.
     */
    private String jmeno;
    private int ID;
    private int[] lokace;

    /**
     * Prazdny konstruktor k nacteni tridy.
     */
    public Lokace() {

    }

    /**
     * Konstruktor k nacteni lokaci se vsema vlastnostmy.
     * Taky prevadi pole string na int pole.
     * Autor: Michaela Meitnerova
     * @param jmeno
     * @param ID
     * @param lokace
     */
    public Lokace(String jmeno, int ID, String[] lokace) {
        this.jmeno = jmeno;
        this.ID = ID;
        this.lokace = new int[4];
        for (int i = 0; i < lokace.length; i++) {
            this.lokace[i] = Integer.parseInt((lokace[i]));
        }
    }

    @Override
    public String toString() {
        return "Lokace{" +
                "jmeno='" + jmeno + '\'' +
                ", ID=" + ID +
                ", lokace=" + Arrays.toString(lokace) +
                '}';
    }

    /**
     * Settery a gettery.
     * @return
     */
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
