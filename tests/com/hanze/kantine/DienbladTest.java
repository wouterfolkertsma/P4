package com.hanze.kantine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DienbladTest {

    @Test
    void voegToe() {
        Dienblad dienblad = new Dienblad();
        dienblad.voegToe(new Artikel("Foo", 2.5));
        dienblad.voegToe(new Artikel("Foo", 2.5));
        dienblad.voegToe(new Artikel("Foo", 2.5));

        assertEquals(dienblad.getAantalArtikelen(), 3);
        assertEquals(dienblad.getTotaalPrijs(), 7.5);
    }
}