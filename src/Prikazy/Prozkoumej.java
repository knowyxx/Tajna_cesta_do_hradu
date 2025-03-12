package Prikazy;

import Svet.Lokace;
import Svet.SvetovaMapa;
import Svet.Veci;
import postavy.Montra;
import postavy.NPC;

import java.util.Scanner;

public class Prozkoumej implements Prikazy {

    private Lokace aktualniLokace = new Lokace();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String execute() {
        SvetovaMapa mapa = new SvetovaMapa();
        Veci veci = new Veci();
        Montra montra  = new Montra();
        NPC npc = new NPC();
        aktualniLokace = mapa.getAktualniLokace();
        System.out.println("Co chcete prozkoumat?");
        String rozhodnuti = scanner.next();
        if (rozhodnuti.equals("mistnost")) {
            return "Mistnost kde se nachazite " + aktualniLokace + "\n" +
                    "Veci v mistnosti " + veci.VeciNaZemi() + "\n" +
                    "Monstra u vas " + montra.monstraVMistnosti() + "\n" +
                    "NPC kolem vas " + npc.npcVMistnosti();
        } else {
            if (rozhodnuti.equalsIgnoreCase(veci.getJmeno())) {
                return veci.getJmeno() + " " + veci.getSila() + " " + veci.getPopis();
            }
        }
//        switch (rozhodnuti){
//            case "mistnost": return "Mistnost kde se nachazite "+ aktualniLokace+"\n"+
//                    "Veci v mistnosti "+veci.VeciNaZemi()+"\n"+
//                    "Monstra u vas "+montra.monstraVMistnosti()+"\n"+
//                    "NPC kolem vas "+npc.npcVMistnosti();
//
//            default: if (rozhodnuti.equalsIgnoreCase(veci.getJmeno())){
//                return veci.getJmeno()+" "+veci.getSila()+" "+veci.getPopis();
//            }
//        }

        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
