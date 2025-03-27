package Prikazy;

import Svet.SvetovaMapa;
import postavy.Hrac;
import postavy.Montra;
import postavy.NPC;

import java.util.Scanner;

public class Prozkoumej implements Prikazy {


    private Scanner scanner = new Scanner(System.in);
    private SvetovaMapa mapa;
    private Montra montra;
    private Batoh batoh;
    private NPC npc;

    @Override
    public String execute() {
        System.out.println("Co chcete prozkoumat?");
        String rozhodnuti = scanner.next();
        if (rozhodnuti.equalsIgnoreCase("mistnost")) {
            if (montra.monstraVMistnosti(mapa)){
                return "Mistnost kde se nachazite " + mapa.getAktualniLokace().getJmeno() + "\n" +
                        "Monstra u vas " + montra.monstraVMistnosti(mapa) + "\n" +
                        "Veci v mistnosti " + mapa.getVecy().containsKey(mapa.getAktualniLokace().getID()) + "\n" +
                        "NPC kolem vas " + npc.npcVMistnosti(mapa);
            }else return "Mistnost kde se nachazite " + mapa.getAktualniLokace().getJmeno() + "\n" +
                    "Veci v mistnosti " + mapa.getVecy().containsKey(mapa.getAktualniLokace().getID()) + "\n" +
                    "NPC kolem vas " + npc.npcVMistnosti(mapa);

        } else if (rozhodnuti.equalsIgnoreCase("vec")){
            for (int i = 0; i < batoh.getBatoh().size(); i++) {
                if (rozhodnuti.equalsIgnoreCase(batoh.getBatoh().get(i).getJmeno())) {
                    return "Vec: "+batoh.getBatoh().get(i).getJmeno()+"\n"+
                            "Sila: "+batoh.getBatoh().get(i).getSila()+"\n"+
                            "Popis: "+batoh.getBatoh().get(i).getPopis();
                }
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
        this.montra = montra;
    }

    @Override
    public void setNPC(NPC npc) {
        this.npc = npc;
    }

    @Override
    public void setHrac(Hrac hrac) {

    }

    @Override
    public void SetBatoh(Batoh batoh) {
        this.batoh = batoh;
    }
}
