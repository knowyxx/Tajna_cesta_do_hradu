package Prikazy;

import Svet.Lokace;
import Svet.SvetovaMapa;
import postavy.Hrac;
import postavy.Montra;
import postavy.NPC;

import java.util.Scanner;

public class Boj implements Prikazy{
    private SvetovaMapa mapa;
    private Montra montra;
    private Hrac hrac;
    private Scanner scanner = new Scanner(System.in);


    @Override
    public String execute() {
        //System.out.println("Na koho chcete zautocit?");
        if (mapa.getMontras().containsKey(mapa.getAktualniLokace().getID())){
            boj();
        }
        return "";
    }

    public String boj (){
        hrac = mapa.getHrac();
        montra = mapa.getMontras().get(mapa.getAktualniLokace().getID());
        String viteznik="";
        System.out.println("Napiste 'utok' abyste zautocili.");
        while (hrac.isJeZivy() || montra.isJeZivy()){
            String odpoved = scanner.next();
            if (odpoved.equalsIgnoreCase("utok")){
                int uder = 0;
                if (!mapa.getBatoh().getBatoh().isEmpty()) {
                    System.out.println("A s cim chcete uderit?");
                    odpoved = scanner.next();
                    for (int i = 0; i < mapa.getBatoh().getBatoh().size(); i++) {
                        if (mapa.getBatoh().getBatoh().get(i).getVec().getJmeno().equalsIgnoreCase(odpoved.toLowerCase())) {
                            montra.protivnikUtok(hrac.getUtok(), mapa.getBatoh().getBatoh().get(i).getVec().getSila());
                            uder = montra.protivnikUtok(hrac.getUtok(), mapa.getBatoh().getBatoh().get(i).getVec().getSila());
                        } else if (odpoved.equalsIgnoreCase("nic")) {
                            montra.protivnikUtok(hrac.getUtok(), 0);
                            uder = montra.protivnikUtok(hrac.getUtok(), 0);
                        }

                    }
                }
                System.out.println(montra.getZivoty() + " - " + uder + " = " + (montra.getZivoty() - uder));
            }else System.out.println(montra.getJmeno()+": Ha ty na me nebudes utocit?");
            hrac.protivnikUtok(montra.getUtok());
            System.out.println("Hrac: "+mapa.getHrac().getZivoty()+" - "+hrac.protivnikUtok(montra.getUtok())+" = "+(mapa.getHrac().getZivoty()-hrac.protivnikUtok(montra.getUtok())));
            hrac.isJeZivy();
            montra.isJeZivy();
            if (hrac.isJeZivy()&&!montra.isJeZivy()){
                System.out.println("Zvitezili jste!");
                viteznik = "hrac";
            }
            if (!hrac.isJeZivy()&&montra.isJeZivy()){
                System.out.println("Prohrali jste...");
                viteznik = montra.getJmeno();
            }
            hrac = mapa.getHrac();
            montra = mapa.getMontras().get(mapa.getAktualniLokace().getID());
        }
        return viteznik;
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

    }

    @Override
    public void setHrac(Hrac hracc) {
        this.hrac = hracc;
    }

    @Override
    public Hrac getHrac() {
        return hrac;
    }

    @Override
    public Montra getMontra() {
        return  montra;
    }

    @Override
    public void SetBatoh(Batoh batoh) {

    }
}
