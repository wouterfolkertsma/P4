package com.hanze.kantine;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

@Entity
@Table(name = "facturen")
public class Factuur implements Serializable {
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue
    private Long id;

    @Column(name = "datum")
    private LocalDate datum;

    @Column(name = "korting")
    private double korting;

    @Column(name = "totaal")
    private double totaal;

    @OneToMany(targetEntity = FactuurRegel.class, cascade=CascadeType.ALL)
    private List<FactuurRegel> regels;

    public Factuur(Dienblad klant, LocalDate datum) {
        totaal = 0;
        korting = 0;
        this.datum = datum;
        regels = new ArrayList<>();
        verwerkBestelling(klant);
    }

    private void verwerkBestelling(Dienblad dienblad) {
        Stack<Artikel> artikels = dienblad.getArtikelen();
        this.totaal = artikels.size();
        Iterator<Artikel> artikelIterator = dienblad.getArtikelen().iterator();

        double amountToPay = 0d;
        while (artikelIterator.hasNext()) {
            Artikel artikel = artikelIterator.next();
            amountToPay += artikel.getPrijs();
            regels.add(new FactuurRegel(this, artikel));
        }

        Persoon klant = dienblad.getKlant();

        if(klant instanceof KortingskaartHouder) {
            KortingskaartHouder kortingskaartHouder = (KortingskaartHouder) klant;
            double discount = amountToPay * kortingskaartHouder.geefKortingsPercentage();
            if(kortingskaartHouder.heeftMaximum() && discount > kortingskaartHouder.geefMaximum()) {
                discount = kortingskaartHouder.geefMaximum();
            }

            System.out.printf("Een %s heeft \u20ac%.2f korting gekregen\n", klant.toString(), discount);
            this.korting = discount;
        }
    }

    public double getKorting() {
        return korting;
    }

    public double getTotaal() {
        return totaal;
    }

    public List<FactuurRegel> getRegels() {
        return regels;
    }

    @Override
    public String toString() {
        return "Factuur{" +
                "id=" + id +
                ", datum=" + datum +
                ", korting=" + korting +
                ", totaal=" + totaal +
                '}';
    }
}
