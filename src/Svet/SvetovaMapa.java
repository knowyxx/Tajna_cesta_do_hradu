package Svet;

import Prikazy.Batoh;
import postavy.Hrac;
import postavy.Montra;
import postavy.NPC;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class SvetovaMapa {

    private HashMap<Integer, Lokace> svet = new HashMap();
    private HashMap<Integer, Veci> vecy = new HashMap<>();
    private HashMap<Integer, Montra> montras = new HashMap<>();
    private HashMap<Integer, NPC> npcs = new HashMap<>();
    private HashMap<Integer, String> text = new HashMap<>();
    private Batoh batoh = new Batoh();
    private Hrac hrac;
    private int start = 0;
    private int aktualniLokace = start;

    public boolean nacistMapu(){
        try(BufferedReader br = new BufferedReader(new FileReader("mapa.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split(",");
                String[] split2 = (Arrays.copyOfRange(split,2,6));
                Lokace lokace = new Lokace(
                        split[1],
                        Integer.parseInt(split[0]),
                        split2
                );
                svet.put(Integer.parseInt(split[0]), lokace);
                if (!split[6].isEmpty()) {
                    Veci veci = new Veci(
                            Integer.parseInt(split[0]),
                            split[6],
                            Integer.parseInt(split[7]),
                            split[8]
                    );
                    vecy.put(Integer.parseInt(split[0]), veci);
                }
                if (split.length>12) {
                    Montra montra = new Montra(
                            Integer.parseInt(split[0]),
                            split[9],
                            Integer.parseInt(split[10]),
                            Integer.parseInt(split[11]),
                            true,
                            split[12]
                    );
                    montras.put(Integer.parseInt(split[0]),montra);
                }
                if (split.length<12&&split.length>10) {
                    NPC npc = new NPC(
                            Integer.parseInt(split[0]),
                            split[9],
                            split[10]
                    );
                    npcs.put(Integer.parseInt(split[0]),npc);
                }
            }
            hrac = new Hrac(
                    100,
                    15,
                    true,
                    batoh
            );
            try(BufferedReader br2 = new BufferedReader(new FileReader("text.csv"))) {
                String line2;
                while ((line2 = br2.readLine()) != null) {
                    String[] split3 = line2.split(",");
                    text.put(Integer.parseInt(split3[0]),split3[1]);
                }
            }
            return true;
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
    }

    public String pohyb(String direkce){
        int cislo;
        String smer;
        switch (direkce.toLowerCase()){
            case "sever":
                cislo = 0;
                smer = "sever";
                break;
            case "vychod":
                cislo = 1;
                smer = "vychod";
                break;
            case "jih":
                cislo = 2;
                smer = "jih";
                break;
            case "zapad":
                cislo = 3;
                smer = "zapad";
                break;
            default: return "Spatny vstup musi byt sever,vychod,jih,zapad!";
        }
        int novaPozice = svet.get(aktualniLokace).getLokace()[cislo];
        if (novaPozice==-1){
            return "Nemuzete jit na "+smer;
        }else {
            int pozice = aktualniLokace;
            aktualniLokace = novaPozice;
            System.out.println("Pohli jste se z "+svet.get(pozice).getJmeno()+" do "+svet.get(novaPozice).getJmeno());
            if (text.containsKey(getAktualniLokace().getID())) {
                System.out.println(text.get(getAktualniLokace().getID()));
            }
            return "";
        }
    }

    public void updatovaniVeci(Veci veciVBatohu){
        if (!vecy.containsValue(veciVBatohu)){
            vecy.put(aktualniLokace,veciVBatohu);
        } else vecy.remove(veciVBatohu.getID());
    }

    public void updatovaniMonstra(Montra montraa){
        if (montras.containsValue(montraa)){
            if (!montraa.isJeZivy()){
                montras.remove(montraa.getID());
            }
            montras.remove(aktualniLokace);
            montras.put(aktualniLokace,montraa);
        } else montras.remove(montraa.getID());

    }



//    public String polozeniVeci(Veci veci){
//        if (batoh.getBatoh().contains(veci)){
//
//        }
//        batoh.getBatoh()
//        vecy.get(getAktualniLokace().getID()).setID();
//
//    }

    @Override
    public String toString() {
        return "Vec: "+vecy;
    }

    public Lokace getAktualniLokace(){
        return svet.get(aktualniLokace);
    }

    public HashMap<Integer, Lokace> getSvet(){
        return svet;
    }

    public HashMap<Integer, Veci> getVecy() {
        return vecy;
    }

    public void setSvet(HashMap<Integer, Lokace> svet) {
        this.svet = svet;
    }

    public void setVecy(HashMap<Integer, Veci> vecy) {
        this.vecy = vecy;
    }

    public HashMap<Integer, Montra> getMontras() {
        return montras;
    }

    public void setMontras(HashMap<Integer, Montra> montras) {
        this.montras = montras;
    }

    public HashMap<Integer, NPC> getNpcs() {
        return npcs;
    }

    public void setNpcs(HashMap<Integer, NPC> npcs) {
        this.npcs = npcs;
    }

    public Batoh getBatoh() {
        return batoh;
    }

    public void setBatoh(Batoh batoh) {
        this.batoh = batoh;
    }

    public Hrac getHrac() {
        return hrac;
    }

    public void setHrac(Hrac hrac) {
        this.hrac = hrac;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setAktualniLokace(int aktualniLokace) {
        this.aktualniLokace = aktualniLokace;
    }

    public HashMap<Integer, String> getText() {
        return text;
    }

    public void setText(HashMap<Integer, String> text) {
        this.text = text;
    }
}
