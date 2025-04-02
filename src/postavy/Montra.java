package postavy;

import Svet.SvetovaMapa;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Montra {

    private int ID;
    private String jmeno;
    private int zivoty;
    private int utok;
    private boolean jeZivy = true;
    private String text;
    private HashMap<Integer, Montra> monstra;


    /**
     * Konstruktor k nacteni monstra se vsema vlastnostmy.
     * @param ID
     * @param jmeno
     * @param zivoty
     * @param utok
     * @param jeZivy
     * @param text
     */
    public Montra(int ID, String jmeno, int zivoty, int utok, boolean jeZivy, String text) {
        this.ID = ID;
        this.jmeno = jmeno;
        this.zivoty = zivoty;
        this.utok = utok;
        this.jeZivy = jeZivy;
        this.text = text;
        monstra = new HashMap();
    }

    /**
     * Prazdny konstruktor k nacteni tridy.
     */
    public Montra() {
        monstra = new HashMap();
    }

    /**
     * Metoda ktera vrati kolik monstrovi zustane zivotu po utoku.
     * @param montraa
     * @param utok
     * @param vec
     * @return
     */
    public int protivnikUtok(Montra montraa,int utok, int vec){
        setZivoty(montraa.getZivoty()-utok-vec);
        return montraa.getZivoty();
    }

    @Override
    public String toString() {
        return "Montra{" +
                "ID=" + ID +
                ", jmeno='" + jmeno + '\'' +
                ", zivoty=" + zivoty +
                ", utok=" + utok +
                ", jeZivy=" + jeZivy +
                ", text='" + text + '\'' +
                ", monstra=" + monstra +
                '}';
    }

    /**
     * Settery a gettery.
     * @return
     */
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public int getZivoty() {
        return zivoty;
    }

    public void setZivoty(int zivoty) {
        this.zivoty = zivoty;
    }

    public int getUtok() {
        return utok;
    }

    public void setUtok(int utok) {
        this.utok = utok;
    }

    /**
     * getter ktery pozna jestli monstrum je zivi dokud nema pod 1 zivotu.
     * @return
     */
    public boolean isJeZivy() {
        if (zivoty<=0){
            return false;
        }else return jeZivy;
    }

    public void setJeZivy(boolean jeZivy) {
        this.jeZivy = jeZivy;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public HashMap<Integer, Montra> getMonstra() {
        return monstra;
    }

    public void setMonstra(HashMap<Integer, Montra> monstra) {
        this.monstra = monstra;
    }


}
