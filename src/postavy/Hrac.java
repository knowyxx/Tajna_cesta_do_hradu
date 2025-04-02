package postavy;

import Prikazy.Batoh;

public class Hrac {

    private int zivoty;
    private int utok;
    private Batoh batoh;

    /**
     * Konstruktor k nacteni hrace se vsema vlastnostmy.
     * @param zivoty
     * @param utok
     * @param batoh
     */
    public Hrac(int zivoty, int utok, Batoh batoh) {
        this.zivoty = zivoty;
        this.utok = utok;
        this.batoh = batoh;
    }

    /**
     * Prazdny konstruktor k nacteni tridy.
     */
    public Hrac() {
    }

    /**
     * Metoda ktera vrati kolik hracovi zustane zivotu po utoku.
     * @param hracc
     * @param utok
     * @return
     */
    public int protivnikUtok(Hrac hracc, int utok ){
        setZivoty(hracc.getZivoty()-utok);
        return hracc.getZivoty();
    }


    /**
     * Settery a gettery.
     * @return
     */
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

    public Batoh getBatoh() {
        return batoh;
    }

    public void setBatoh(Batoh batoh) {
        this.batoh = batoh;
    }
}
