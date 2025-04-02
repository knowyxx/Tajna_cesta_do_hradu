package postavy;

import Svet.SvetovaMapa;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class NPC {

    private int ID;
    private String jmeno;
    private String text;
    private HashMap<Integer,NPC> npc;

    /**
     * Konstruktor k nacteni hrace se vsema vlastnostmy.
     * @param ID
     * @param jmeno
     * @param text
     */
    public NPC(int ID, String jmeno, String text) {
        this.ID = ID;
        this.jmeno = jmeno;
        this.text = text;
        npc = new HashMap<>();
    }

    /**
     * Prazdny konstruktor k nacteni tridy.
     */
    public NPC() {
        npc = new HashMap<>();
    }

    /**
     * Settery a gettery.
     * @return
     */
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public HashMap<Integer, NPC> getNpc() {
        return npc;
    }

    public void setNpc(HashMap<Integer, NPC> npc) {
        this.npc = npc;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

}
