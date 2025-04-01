package postavy;

import Svet.SvetovaMapa;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class NPC {

    private int ID;
    private String jmeno;
    private String text;
    private HashMap<Integer,NPC> npc;
    private Scanner scanner = new Scanner(System.in);

    public NPC(int ID, String jmeno, String text) {
        this.ID = ID;
        this.jmeno = jmeno;
        this.text = text;
        npc = new HashMap<>();
    }

    public NPC() {
        npc = new HashMap<>();
    }

    public boolean npcVMistnosti(SvetovaMapa mapa){
        //System.out.println(npc.get(mapa.getAktualniLokace().getID()));
        System.out.println(npc);
        if (npc.containsKey(mapa.getAktualniLokace().getID())){
            //System.out.println( npc.get(mapa.getAktualniLokace().getID()).getJmeno()+" je v mistnosti");
            return true;
        }
        return false;
    }

//    public String nacteniNPC(){
//        npc = new HashMap<>();
//        try (BufferedReader br = new BufferedReader(new FileReader("textNPC.csv"))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                String[] split = line.split(",");
//                NPC npc1 = new NPC(
//                        Integer.parseInt(split[0]),
//                        split[1],
//                        split[2]
//                );
//                npc.put(npc1.getID(), npc1);
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return null;
//    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public HashMap<Integer, NPC> getNpc() {
        return npc;
    }

    public void setNpc(HashMap<Integer, NPC> npc) {
        this.npc = npc;
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
