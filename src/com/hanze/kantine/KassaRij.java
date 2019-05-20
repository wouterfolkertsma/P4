package com.hanze.kantine;

import java.util.LinkedList;
import java.util.Queue;

public class KassaRij {

    private Queue<Dienblad> kassaRij;
    /**
     * Constructor
     */
    public KassaRij() {
        this.kassaRij = new LinkedList<>();
    }

    /**
     * Persoon sluit achter in de rij aan
     *
     * @param dienblad
     */
    public void sluitAchteraan(Dienblad dienblad) {
        this.kassaRij.add(dienblad);
    }

    /**
     * Indien er een rij bestaat, de eerste klant uit
     * de rij verwijderen en retourneren.
     * Als er niemand in de rij staat geeft deze null terug.
     *
     * @return Eerste klant in de rij of null
     */
    public Dienblad eerstePersoonInRij() {
        return this.kassaRij.remove();
    }

    /**
     * Methode kijkt of er personen in de rij staan.
     *
     * @return Of er wel of geen rij bestaat
     */
    public boolean erIsEenRij() {
        return this.kassaRij.size() > 0;
    }
}