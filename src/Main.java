import Prikazy.Batoh;
import Svet.SvetovaMapa;
import postavy.Montra;

public class Main {
    public static void main(String[] args) {
//        SvetovaMapa mapa = new SvetovaMapa();
        Montra montra = new Montra();
//        Batoh batoh = new Batoh();
        montra.nacteniMonstru();

//monstra a npc narvat do svetovemapy

        Konzole konzole = new Konzole();
        konzole.inicializace();
        konzole.start();
        System.out.println(montra.getMonstra());
//        System.out.println(mapa.getSvet());
//        System.out.println(batoh.getBatoh().toString());
    }
}