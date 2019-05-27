package com.hanze.kantine;

public class Kantine {

    private Kassa kassa;
    private KassaRij kassarij;
    private KantineAanbod kantineAanbod;

    /**
     * Constructor
     */
    public Kantine() {
        kassarij = new KassaRij();
        kassa = new Kassa(kassarij);
    }

    /**
     * In deze methode wordt een Persoon en Dienblad gemaakt
     * en aan elkaar gekoppeld. Maak twee Artikelen aan
     * en plaats deze op het dienblad. Tenslotte sluit de
     * Persoon zich aan bij de rij voor de kassa.
     */
//    public void loopPakSluitAan() {
//        Persoon persoon = new Persoon("0000", "Jan", "van der Balk", new Datum(1, 1, 2000), 'm');
//        Dienblad dienblad = new Dienblad(persoon);
//
//        Artikel broodjeFrikandel = new Artikel("Broodje Frikandel", 1.8);
//        Artikel broodjeGezond = new Artikel("Broodje Gezond", 2.5);
//
//        dienblad.voegToe(broodjeFrikandel);
//        dienblad.voegToe(broodjeGezond);
//
//        kassarij.sluitAchteraan(dienblad);
//    }
    public void loopPakSluitAan(Persoon persoon, String[] artikelnamen) {
        Dienblad dienblad = new Dienblad(persoon);
        dienblad.setKlant(persoon);

        for(String artikelnaam : artikelnamen) {
            Artikel artikel = kantineAanbod.getArtikel(artikelnaam);
            dienblad.voegToe(artikel);
        }
        kassarij.sluitAchteraan(dienblad);
    }

    /**
     * Deze methode handelt de rij voor de kassa af.
     */
    public void verwerkRijVoorKassa() {
        while (kassarij.erIsEenRij()) {
            Dienblad dienblad = kassarij.eerstePersoonInRij();
            kassa.rekenAf(dienblad);
        }
    }


    /**
     * Deze methode reset de bijgehouden telling van
     * het aantal artikelen en "leegt" de inhoud van de kassa.
     */
    public void resetKassa() {
        kassa.resetKassa();
    }

    public Kassa getKassa() {
        return kassa;
    }

    public KantineAanbod getKantineAanbod() {
        return kantineAanbod;
    }

    public void setKantineAanbod(KantineAanbod kantineAanbod) {
        this.kantineAanbod = kantineAanbod;
    }
}