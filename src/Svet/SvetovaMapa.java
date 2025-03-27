package Svet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class SvetovaMapa {

    private HashMap<Integer, Lokace> svet = new HashMap();
    private HashMap<Integer, Veci> vecy = new HashMap<>();
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

        }
        return null;
    }

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
}
