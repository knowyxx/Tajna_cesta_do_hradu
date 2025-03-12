package postavy;

import Svet.Lokace;
import Svet.SvetovaMapa;
import Svet.Veci;

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
    private HashMap<Integer, Montra> monstra = new HashMap();


    public Montra(int ID, String jmeno, int zivoty, int utok, boolean jeZivy, String text) {
        this.ID = ID;
        this.jmeno = jmeno;
        this.zivoty = zivoty;
        this.utok = utok;
        this.jeZivy = jeZivy;
        this.text = text;
    }

    public Montra() {
    }

    public String voditko(){
        SvetovaMapa mapa = new SvetovaMapa();
        return monstra.get(mapa.getAktualniLokace()).text;
    }

    public String monstraVMistnosti(){
        SvetovaMapa mapa = new SvetovaMapa();
        for (int i = 0; i < 7; i++) {
            if (mapa.getAktualniLokace().getID()==this.ID){
                return this.jmeno+" "+this.zivoty+" "+this.utok;
            }
            ID++;
        }
        return "Neni zadny monstrum v mistnosti";
    }

    public int protivnikUtok(int utok, int vec){
        return zivoty-utok-vec;
    }

    public String nacteniMonstru(){
        try (BufferedReader br = new BufferedReader(new FileReader("monstra.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split(",");
                Montra montra = new Montra(
                        Integer.parseInt(split[0]),
                        split[1],
                        Integer.parseInt(split[2]),
                        Integer.parseInt(split[3]),
                        true,
                        split[4]
                );
                monstra.put(Integer.parseInt(split[0]), montra);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public String ulozeniMonstru(){
        return null;
    }

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
