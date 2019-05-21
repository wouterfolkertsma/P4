package com.hanze.kantine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArtikelTest {

    @Test
    void getPrijs() {
        Artikel artikel = new Artikel();
        assertEquals(artikel.getPrijs(), 0.0);

        Artikel artikel1 = new Artikel("Foo", 5.0);
        assertEquals(artikel1.getPrijs(), 5.0);
    }

    @Test
    void setPrijs() {
        Artikel artikel = new Artikel("Foo", 5.0);
        assertEquals(artikel.getPrijs(), 5.0);

        artikel.setPrijs(10.0);
        assertEquals(artikel.getPrijs(), 10.0);
    }

    @Test
    void getNaam() {
        Artikel artikel = new Artikel();
        assertNull(artikel.getNaam());

        Artikel artikel1 = new Artikel("Foo", 5.0);
        assertEquals(artikel1.getNaam(), "Foo");
    }

    @Test
    void setNaam() {
        Artikel artikel = new Artikel("Foo", 5.0);
        assertEquals(artikel.getNaam(), "Foo");

        artikel.setNaam("Bar");
        assertEquals(artikel.getNaam(), "Bar");
    }
}