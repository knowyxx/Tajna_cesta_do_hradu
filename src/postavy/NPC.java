package postavy;

import Svet.SvetovaMapa;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class NPC {

    private int ID = 6;
    private String jmeno;

    public String npcVMistnosti(){
        SvetovaMapa mapa = new SvetovaMapa();
        if (mapa.getAktualniLokace().getID()==ID){
            return this.jmeno;
        }
        return "Zadny NPC v mistnosti";
    }

    public String konverzace(){
        try (BufferedReader br = new BufferedReader(new FileReader("textNPC.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
}
