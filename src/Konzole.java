import Prikazy.Prikazy;
import Prikazy.Pohyb;
import Prikazy.Pomoc;
import Prikazy.Konec;
import Prikazy.Batoh;
import Prikazy.Boj;
import Prikazy.Mluv;
import Prikazy.Napoveda;
import Prikazy.Prozkoumej;
import Svet.SvetovaMapa;
import Svet.Text;
import postavy.Hrac;
import postavy.Montra;
import postavy.NPC;

import java.util.HashMap;
import java.util.Scanner;

public class Konzole {
    private boolean exit = false;
    private HashMap<String, Prikazy> mapa = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);
    private SvetovaMapa svetovaMapa = new SvetovaMapa();
    private Montra montra = new Montra();
    private Hrac hrac = new Hrac();
    private NPC npc = new NPC();
    private String prikaz="";

    public void inicializace(){
        mapa.put("batoh", new Batoh());
        mapa.put("boj", new Boj());
        mapa.put("konec", new Konec());
        mapa.put("mluv", new Mluv());
        mapa.put("napoveda", new Napoveda());
        mapa.put("pohyb", new Pohyb());
        mapa.put("pomoc", new Pomoc());
        mapa.put("prozkoumej", new Prozkoumej());
        svetovaMapa.nacistMapu();
        montra.nacteniMonstru();
        npc.nacteniNPC();
    }
    public String udelejPrikaz(){
        System.out.println(">>");
        prikaz = scanner.nextLine();
        prikaz = prikaz.trim();
        prikaz = prikaz.toLowerCase();
        if (mapa.containsKey(prikaz)){
            mapa.get(prikaz).setSvet(svetovaMapa);
            mapa.get(prikaz).setMonstra(montra);
            mapa.get(prikaz).setHrac(hrac);
            System.out.println(">> "+mapa.get(prikaz).execute());
            if(mapa.get(prikaz).equals("batoh")){
                svetovaMapa = mapa.get(prikaz).getSvet();
            }
            return prikaz;
        }else System.out.println("Prikaz neexistuje");
        return "spatny";
    }

    public void start(){
        inicializace();
        String text = Text.nacistText();
        System.out.println(text);
        //try {
            do {
                udelejPrikaz();
                if (!udelejPrikaz().equals("spatny")){
                    exit = mapa.get(prikaz).exit();
                }
            }while (!exit);
        //}catch (Exception e){
            //System.out.println(e.getMessage());
        //}
    }

}
