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
            if(mapa.get(prikaz).toString().equals("batoh")){
                svetovaMapa = mapa.get(prikaz).getSvet();
            }
            if (mapa.get(prikaz).equals("boj")){
                svetovaMapa.setHrac(mapa.get(prikaz).getHrac());
                montra=mapa.get(prikaz).getMontra();
            }
            System.out.println(">> "+mapa.get(prikaz).execute());
            exit= mapa.get(prikaz).exit();
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
            }while (!exit);
        //}catch (Exception e){
            //System.out.println(e.getMessage());
        //}
    }

}
