package com.hanze.kantine;

public class KantineMedewerker extends Persoon implements KortingskaartHouder {

    private int medewerkersnummer;
    private boolean kassa;

    public KantineMedewerker(String BSN, String voornaam, String achternaam, Datum geboorteDatum, char geslacht, int medewerkersnummer, boolean kassa) {
        super(BSN, voornaam, achternaam, geboorteDatum, geslacht);
        this.medewerkersnummer = medewerkersnummer;
        this.kassa = kassa;
    }

    public int getMedewerkersnummer() {
        return medewerkersnummer;
    }

    public void setMedewerkersnummer(int medewerkersnummer) {
        this.medewerkersnummer = medewerkersnummer;
    }

    public boolean isKassa() {
        return kassa;
    }

    public void setKassa(boolean kassa) {
        this.kassa = kassa;
    }

    public String toString(){
        return "Kantine Medewerker";
    }

    @Override
    public double geefKortingsPercentage() {
        return 0.35d;
    }

    @Override
    public boolean heeftMaximum() {
        return false;
    }

    @Override
    public double geefMaximum() {
        return 0;
    }
}