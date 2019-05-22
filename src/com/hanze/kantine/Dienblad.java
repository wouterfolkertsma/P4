package com.hanze.kantine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Dienblad {

    private Stack<Artikel> artikelen;
    private Persoon klant;
    /**
     * Constructor
     */
    public Dienblad() {
        this.artikelen = new Stack<>();
    }

    public Dienblad(Persoon klant) {
        this.klant = klant;
        this.artikelen = new Stack<>();
    }

    /**
     * Methode om artikel aan dienblad toe te voegen
     *
     * @param artikel
     */
    public void voegToe(Artikel artikel) {
        this.artikelen.add(artikel);
    }

    public Stack<Artikel> getArtikelen() {
        return artikelen;
    }

    public void setArtikelen(Stack<Artikel> artikelen) {
        this.artikelen = artikelen;
    }

    public Persoon getKlant() {
        return klant;
    }

    public void setKlant(Persoon klant) {
        this.klant = klant;
    }
}

