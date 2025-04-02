package Svet;

/**
 * Trida pro veci
 */
public class Veci {

    /**
     * VLastnosti veci.
     */
    private int ID;
    private String jmeno;
    private int sila;
    private String popis;
    private Veci vec;

    /**
     * Prazdny konstruktor k nacteni tridy.
     */
    public Veci() {
    }

    /**
     * Konstruktor k nacteni vec se vsema vlastnostmy.
     * @param ID
     * @param jmeno
     * @param sila
     * @param popis
     */
    public Veci(int ID, String jmeno, int sila, String popis) {
        this.ID = ID;
        this.jmeno = jmeno;
        this.sila = sila;
        this.popis = popis;
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

    public int getSila() {
        return sila;
    }

    public void setSila(int sila) {
        this.sila = sila;
    }

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Veci getVec() {
        return vec;
    }

    public void setVec(Veci vec) {
        this.vec = vec;
    }
}
