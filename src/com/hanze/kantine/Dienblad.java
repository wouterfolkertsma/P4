package com.hanze.kantine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Dienblad {

    private ArrayList<Artikel> artikelen;
    private Persoon klant;
    /**
     * Constructor
     */
    public Dienblad() {
        this.artikelen = new ArrayList<>();
    }

    public Dienblad(Persoon klant) {
        this.klant = klant;
        this.artikelen = new ArrayList<>();
    }

    /**
     * Methode om artikel aan dienblad toe te voegen
     *
     * @param artikel
     */
    public void voegToe(Artikel artikel) {
        this.artikelen.add(artikel);
    }

    /**
     * Methode om aantal artikelen op dienblad te tellen
     *
     * @return Het aantal artikelen
     */
    public int getAantalArtikelen() {
        return this.artikelen.size();
    }

    /**
     * Methode om de totaalprijs van de artikelen
     * op dienblad uit te rekenen
     *
     * @return De totaalprijs
     */
    public double getTotaalPrijs() {
        double totaalPrijs = 0;

        for (Artikel artikel : this.artikelen) {
            totaalPrijs += artikel.getPrijs();
        }

        return totaalPrijs;
    }

    public ArrayList<Artikel> getArtikelen() {
        return artikelen;
    }

    public void setArtikelen(ArrayList<Artikel> artikelen) {
        this.artikelen = artikelen;
    }

    public Persoon getKlant() {
        return klant;
    }

    public void setKlant(Persoon klant) {
        this.klant = klant;
    }
}

