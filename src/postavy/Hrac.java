package postavy;

import Prikazy.Batoh;

public class Hrac {

    private int zivoty;
    private int utok;
    private boolean jeZivy = true;
    private Batoh batoh = new Batoh();

    public int protivnikUtok(int utok){
        return zivoty-utok;
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

    public boolean isJeZivy() {
        if (zivoty<=0){
            return false;
        }else return jeZivy;

    }

    public void setJeZivy(boolean jeZivy) {
        this.jeZivy = jeZivy;
    }

}
