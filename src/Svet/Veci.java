package Svet;

import java.util.HashMap;

public class Veci {
    private int ID;
    private String jmeno;
    private int sila;
    private String popis;
    private Veci vec;

    public Veci() {

    }

    public Veci(int ID, Veci vec) {
        this.ID = ID;
        this.vec = vec;
    }

    public Veci(int ID, String jmeno, int sila, String popis) {
        this.ID = ID;
        this.jmeno = jmeno;
        this.sila = sila;
        this.popis = popis;
    }

    public String VeciNaZemi(){
        SvetovaMapa mapa = new SvetovaMapa();
        for (int i = 0; i < 7; i++) {
            if (mapa.getAktualniLokace().getID()==this.ID){
                return this.jmeno;
            }
            ID++;
        }
        return "Nic neni na zemi";
    }

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

    public String nacteniVeci(){
        return null;
    }

    public String ukladaniVeci(){
        return null;
    }
}
