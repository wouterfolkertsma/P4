package com.hanze.kantine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KassaTest {

    @Test
    void rekenAf() {
        KassaRij kassaRij = new KassaRij();
        Kassa kassa = new Kassa(kassaRij);

        assertEquals(kassa.getKasInhoud(), 0.0);
        assertEquals(kassa.getAantalArtikelen(), 0);

        Dienblad dienblad = new Dienblad();
        dienblad.voegToe(new Artikel("Foo", 5.0));
        dienblad.voegToe(new Artikel("Bar", 2.5));

        kassa.rekenAf(dienblad);

        assertEquals(kassa.getKasInhoud(), 7.5);
        assertEquals(kassa.getAantalArtikelen(), 2);

        Dienblad dienblad1 = new Dienblad();
        dienblad1.voegToe(new Artikel("Foo", 5.0));
        dienblad1.voegToe(new Artikel("Bar", 2.5));
        dienblad1.voegToe(new Artikel("FooBar", 1.5));

        kassa.rekenAf(dienblad1);

        assertEquals(kassa.getKasInhoud(), 16.5);
        assertEquals(kassa.getAantalArtikelen(), 5);
    }
}