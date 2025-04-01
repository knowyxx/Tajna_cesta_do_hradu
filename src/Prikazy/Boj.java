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
        while (hrac.getZivoty()<=0 || montra.isJeZivy()){
            String odpoved = scanner.next();
            if (odpoved.equalsIgnoreCase("utok")){
                int uder = hrac.getUtok();
                if (!mapa.getBatoh().getBatoh().isEmpty()) {
                    System.out.println("A s cim chcete uderit?");
                    odpoved = scanner.next();
                    for (int i = 0; i < mapa.getBatoh().getBatoh().size(); i++) {
                        if (mapa.getBatoh().getBatoh().get(i).getVec().getJmeno().equalsIgnoreCase(odpoved.toLowerCase())) {
                            montra.protivnikUtok(montra,hrac.getUtok(), mapa.getBatoh().getBatoh().get(i).getVec().getSila());
                            uder = montra.protivnikUtok(montra,hrac.getUtok(), mapa.getBatoh().getBatoh().get(i).getVec().getSila());
                        } else if (odpoved.equalsIgnoreCase("nic")) {
                            montra.protivnikUtok(montra,hrac.getUtok(), 0);
                            uder = montra.protivnikUtok(montra,hrac.getUtok(), 0);
                        }

                    }
                } else System.out.println(montra.getJmeno()+": "+montra.protivnikUtok(montra,hrac.getUtok(), 0)+"HP");

            }else System.out.println(montra.getJmeno()+": Ha ty na me nebudes utocit?");
            //hrac.protivnikUtok(hrac,montra.getUtok());
            System.out.println("Hrac: "+ hrac.protivnikUtok(hrac,montra.getUtok())+"HP");

            //hrac.isJeZivy(hrac);
            //montra.isJeZivy();
            if (hrac.getZivoty()<=0){
                System.out.println("Prohrali jste...");
                viteznik = montra.getJmeno();
                break;
            }
            if (montra.getZivoty()<=0){
                System.out.println("Zvitezili jste!");
                viteznik = "hrac";
                mapa.getMontras().remove(montra.getID());
                break;
            }
//            if (hrac.isJeZivy(hrac)&&!montra.isJeZivy()){
//                System.out.println("Zvitezili jste!");
//                viteznik = "hrac";
//                mapa.getMontras().get(mapa.getAktualniLokace().getID()).setJeZivy(false);
//            }
//            if (!hrac.isJeZivy(hrac)&&montra.isJeZivy()){
//                //mapa.getHrac().setJeZivy(false);
//            }
            mapa.setHrac(hrac);
            mapa.updatovaniMonstra(montra);
            //mapa.getMontras().get(mapa.getAktualniLokace().getID()).se
            //mapa.setMontras(montra.getMonstra());
            //mapa.updatovaniHrace(hrac);
            //mapa.setHrac(hrac);
            //hrac = mapa.getHrac();
            //montra = mapa.getMontras().get(mapa.getAktualniLokace().getID());
        }
        return viteznik;
    }

    @Override
    public boolean exit() {
        return hrac.getZivoty() <= 0;
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
