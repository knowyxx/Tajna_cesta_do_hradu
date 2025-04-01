package Prikazy;

import Svet.Lokace;
import Svet.SvetovaMapa;
import postavy.Hrac;
import postavy.Montra;
import postavy.NPC;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Napoveda implements Prikazy{

    private Lokace aktualniLokace = new Lokace();
    private SvetovaMapa mapa;
    @Override
    public String execute() {

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

    @Override
    public void setSvet(SvetovaMapa mapa) {
        this.mapa = mapa;
    }

    @Override
    public SvetovaMapa getSvet() {
        return null;
    }

    @Override
    public void setMonstra(Montra montra) {

    }

    @Override
    public void setNPC(NPC npc) {

    }

    @Override
    public void setHrac(Hrac hrac) {

    }

    @Override
    public Hrac getHrac() {
        return null;
    }

    @Override
    public Montra getMontra() {
        return null;
    }

    @Override
    public void SetBatoh(Batoh batoh) {

    }
}
