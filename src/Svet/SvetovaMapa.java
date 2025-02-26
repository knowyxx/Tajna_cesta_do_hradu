package Svet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class SvetovaMapa {

    private HashMap<Integer, Lokace> svet = new HashMap();
    private int start = 0;
    private int aktualniLokace = start;

    public boolean nacistMapu(){
        try(BufferedReader br = new BufferedReader(new FileReader("mapa.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split(",");
                Lokace lokace = new Lokace(
                        split[1],
                        Integer.parseInt(split[0]),

                        new int[]{Integer.parseInt(Arrays.toString(Arrays.copyOfRange(split, 2, 6)))}
                );
                svet.put(Integer.parseInt(split[0]), lokace);
            }
            return true;
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
    }

    public Lokace getaktualniLokace(){
        return svet.get(aktualniLokace);
    }

    public HashMap<Integer, Lokace> getSvet(){
        return svet;
    }
}
