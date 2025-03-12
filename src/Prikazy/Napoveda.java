package Prikazy;

import Svet.Lokace;
import Svet.SvetovaMapa;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Napoveda implements Prikazy{

    private Lokace aktualniLokace = new Lokace();

    @Override
    public String execute() {
        SvetovaMapa mapa = new SvetovaMapa();
        aktualniLokace = mapa.getAktualniLokace();
        try (BufferedReader br = new BufferedReader(new FileReader("napovedaText.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split(",");
                if (aktualniLokace.getID()==Integer.parseInt(split[0])){
                    return split[1];
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "Doslo k chybe";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
