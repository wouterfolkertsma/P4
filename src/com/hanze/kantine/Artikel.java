package com.hanze.kantine;

public class Artikel {

    private double prijs;

    private String naam;

    public Artikel() {}

    public Artikel(String naam, double prijs) {
        this.naam = naam;
        this.prijs = prijs;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    @Override
    public String toString() {
        return "Artikel{" +
                "prijs=" + prijs +
                ", naam='" + naam + '\'' +
                '}';
    }
}