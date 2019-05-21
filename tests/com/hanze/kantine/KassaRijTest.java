package com.hanze.kantine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KassaRijTest {

    @Test
    void sluitAchteraan() {
        Persoon wouter = new Persoon("000", "Wouter", "Folkertsma");
        Persoon maurice = new Persoon("001", "Maurice", "Wijker");
        Persoon dylan = new Persoon("002", "Dylan", "Hiemstra");


        KassaRij kassaRij = new KassaRij();
        Dienblad dienblad = new Dienblad(wouter);
        kassaRij.sluitAchteraan(dienblad);

        Dienblad dienblad1 = new Dienblad(maurice);
        kassaRij.sluitAchteraan(dienblad1);

        Dienblad dienblad2 = new Dienblad(dylan);
        kassaRij.sluitAchteraan(dienblad2);

        assertEquals(kassaRij.eerstePersoonInRij().getKlant().getBSN(), wouter.getBSN());
        assertEquals(kassaRij.eerstePersoonInRij().getKlant().getBSN(), maurice.getBSN());
        assertEquals(kassaRij.eerstePersoonInRij().getKlant().getBSN(), dylan.getBSN());

    }

    @Test
    void erIsEenRij() {
        KassaRij kassaRij = new KassaRij();
        assertFalse(kassaRij.erIsEenRij());

        kassaRij.sluitAchteraan(new Dienblad());
        assertTrue(kassaRij.erIsEenRij());
    }
}