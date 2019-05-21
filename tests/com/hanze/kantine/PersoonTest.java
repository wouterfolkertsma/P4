package com.hanze.kantine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersoonTest {

    @Test
    void getGeboorteDatum() {
        Persoon persoon = new Persoon("0000", "Foo", "Bar", new Datum(8,8, 1997), 'm');
        assertNotEquals(persoon.getGeboorteDatum(), "Onbekend");

        Persoon persoon1= new Persoon("0000", "Foo", "Bar");
        assertEquals(persoon1.getGeboorteDatum(), "Onbekend");
    }

    @Test
    void getGeslacht() {
        Persoon persoon = new Persoon("0000", "Foo", "Bar", new Datum(8,8, 1997), 'm');
        assertEquals(persoon.getGeslacht(), "man");

        Persoon persoon1 = new Persoon("0000", "Foo", "Bar", new Datum(8,8, 1997), 'v');
        assertEquals(persoon1.getGeslacht(), "vrouw");

        Persoon persoon2 = new Persoon("0000", "Foo", "Bar", new Datum(8,8, 1997), 'z');
        assertEquals(persoon2.getGeslacht(), "Onbekend");
    }

    @Test
    void setGeslacht() {
        Persoon persoon = new Persoon("0000", "Foo", "Bar", new Datum(8,8, 1997), 'm');
        assertEquals(persoon.getGeslacht(), "man");

        persoon.setGeslacht('o');
        assertEquals(persoon.getGeslacht(), "Onbekend");
    }
}