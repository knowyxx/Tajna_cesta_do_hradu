package Prikazy;

import Svet.SvetovaMapa;
import postavy.Hrac;
import postavy.Montra;
import postavy.NPC;

import java.util.Scanner;

/**
 * Trida pro boj.
 */
public class Boj implements Prikazy{
    /**
     * Vlastnosti tridy pro metody.
     */
    private SvetovaMapa mapa;
    private Montra montra;
    private Hrac hrac;
    private Scanner scanner = new Scanner(System.in);

    /**
     * Nacteni prikazu ktery nacte boj, jestli monstrum je v mistnosti.
     * @return
     */
    @Override
    public String execute() {
        hrac = mapa.getHrac();
        if (mapa.getMontras().containsKey(mapa.getAktualniLokace().getID())){
            return boj();
        }else{
            return "Zadny monstrum v mistnosti.";
        }
    }

    /**
     * Metoda na boj. Funguje ze clovek musi napsat 'utok', jestli chce zautocit, jinak nezautoci.
     * Uzivatel ma taky na vyber jakou vec chce pouzit pri utoku.
     * @return
     */
    public String boj (){
        hrac = mapa.getHrac();
        montra = mapa.getMontras().get(mapa.getAktualniLokace().getID());
        hrac.setZivoty(100);
        while (hrac.getZivoty()>0 || montra.isJeZivy()){
            System.out.println("Napiste 'utok' abyste zautocili.");
            String odpoved = scanner.next();
            if (odpoved.equalsIgnoreCase("utok")){
                if (!mapa.getHrac().getBatoh().getBatoh().isEmpty()) {
                    System.out.println("A s cim chcete uderit?");
                    odpoved = scanner.next();
                    for (int i = 0; i < mapa.getBatoh().getBatoh().size(); i++) {
                        if (mapa.getBatoh().getBatoh().get(i).getVec().getJmeno().equalsIgnoreCase(odpoved.toLowerCase())) {
                            System.out.println(montra.getJmeno()+": "+montra.protivnikUtok(montra,hrac.getUtok(), mapa.getBatoh().getBatoh().get(i).getVec().getSila())+"HP");
                        } else if (odpoved.equalsIgnoreCase("nic")) {
                            System.out.println(montra.getJmeno()+": "+montra.protivnikUtok(montra,hrac.getUtok(), 0)+"HP");
                        }
                    }
                } else System.out.println(montra.getJmeno()+": "+montra.protivnikUtok(montra,hrac.getUtok(), 0)+"HP");
            }else System.out.println(montra.getJmeno()+": Ha ty na me nebudes utocit?");
            System.out.println("Hrac: "+ hrac.protivnikUtok(hrac,montra.getUtok())+"HP");
            if (hrac.getZivoty()<=0){
                System.out.println("Prohrali jste...");
                break;
            }
            if (montra.getZivoty()<=0){
                System.out.println("Zvitezili jste!");
                mapa.getMontras().remove(montra.getID());
                break;
            }
            mapa.setHrac(hrac);
            mapa.updatovaniMonstra(montra);
        }
        return "";
    }

    /**
     * Dalsi interface metody.
     * @return
     */
    @Override
    public boolean exit() {
        return hrac.getZivoty() <= 0;
    }

    @Override
    public void setSvet(SvetovaMapa mapa) {
        this.mapa = mapa;
    }

    /**
     * Updatovani sveta.
     * @return
     */
    @Override
    public SvetovaMapa getSvet() {
        return null;
    }

    /**
     * Updatovani monstra.
     * @param montra
     */
    @Override
    public void setMonstra(Montra montra) {
        this.montra = montra;
    }

    @Override
    public void setNPC(NPC npc) {

    }

    /**
     * Updatovani hrace.
     * @param hracc
     */
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
