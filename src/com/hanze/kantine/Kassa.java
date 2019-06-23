package com.hanze.kantine;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Stack;

public class Kassa {

    private KassaRij kassaRij;
    private double kasInhoud;
    private int aantalArtikelen;
    private EntityManager manager;

    /**
     * Constructor
     */
    public Kassa(KassaRij kassarij, EntityManager manager) {
        this.kassaRij = kassarij;
        this.kasInhoud = 0;
        this.aantalArtikelen = 0;
        this.manager = manager;
    }

    /**
     * Vraag het aantal artikelen en de totaalprijs op.
     * Tel deze gegevens op bij de controletotalen die voor
     * de kassa worden bijgehouden. De implementatie wordt
     * later vervangen door een echte betaling door de persoon.
     *
     * @param dienblad die moet afrekenen
     */
    public void rekenAf(Dienblad dienblad) {
        Factuur factuur = new Factuur(dienblad, LocalDate.now());

        double amountToPay = factuur.getTotaal();
        Persoon klant = dienblad.getKlant();
        Betaalwijze betaalwijze = klant.getBetaalwijze();

        this.kasInhoud += amountToPay;
        this.aantalArtikelen += factuur.getTotaal();

        EntityTransaction transaction = null;
        try {
            transaction = manager.getTransaction();
            transaction.begin();
            betaalwijze.betaal(amountToPay);
            this.kasInhoud += amountToPay;
            manager.persist(factuur);
            transaction.commit();
            System.out.println(factuur);

            for(FactuurRegel fr : factuur.getRegels()) {
                System.out.println(fr);
            }
        } catch (TeWeinigGeldException e) {
            if(transaction != null) {
                transaction.rollback();
            }

            System.out.printf("%s %s (%s) kan \u20ac%.2f niet betalen!\n",
                    klant.getVoornaam(),
                    klant.getAchternaam(),
                    klant.toString(),
                    amountToPay);
        }

    }

    /**
     * Geeft het aantal artikelen dat de kassa heeft gepasseerd,
     * vanaf het moment dat de methode resetWaarden is aangeroepen.
     *
     * @return aantal artikelen
     */
    public int getAantalArtikelen() {
        return aantalArtikelen;
    }

    /**
     * Geeft het totaalbedrag van alle artikelen die de kass
     * zijn gepasseerd, vanaf het moment dat de methode
     * resetKassa is aangeroepen.
     *
     * @return hoeveelheid geld in de kassa
     */
    public double hoeveelheidGeldInKassa() {
       return this.kasInhoud;
    }

    /**
     * reset de waarden van het aantal gepasseerde artikelen en
     * de totale hoeveelheid geld in de kassa.
     */
    public void resetKassa() {
        this.kasInhoud = 0;
        this.aantalArtikelen = 0;
    }

    /**
     * @return int
     */
    public KassaRij getKassaRij() {
        return kassaRij;
    }

    /**
     * @param kassaRij
     */
    public void setKassaRij(KassaRij kassaRij) {
        this.kassaRij = kassaRij;
    }

    /**
     * @return int
     */
    public double getKasInhoud() {
        return kasInhoud;
    }

    /**
     * @param kasInhoud
     */
    public void setKasInhoud(double kasInhoud) {
        this.kasInhoud = kasInhoud;
    }

    /**
     * @param aantalArtikelen
     */
    public void setAantalArtikelen(int aantalArtikelen) {
        this.aantalArtikelen = aantalArtikelen;
    }
}