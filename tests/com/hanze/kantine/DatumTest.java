package com.hanze.kantine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatumTest {

    @Test
    void bestaatDatum() {
        Datum datum = new Datum(-1, 0, 0);
        assertEquals(datum.getDatumAsString(), "Onbekend");

        Datum datum2 = new Datum(0, 13, 0);
        assertEquals(datum2.getDatumAsString(), "Onbekend");

        Datum datum3 = new Datum(0, 0, 2101);
        assertEquals(datum3.getDatumAsString(), "Onbekend");

        Datum datum4 = new Datum(0, 0, 1899);
        assertEquals(datum4.getDatumAsString(), "Onbekend");

        Datum datum5 = new Datum(34, 1, 1987);
        assertEquals(datum5.getDatumAsString(), "Onbekend");

        Datum datum6 = new Datum(31, 4, 2002);
        assertEquals(datum6.getDatumAsString(), "Onbekend");

        Datum datum7 = new Datum(31, 3, 2000);
        assertNotEquals(datum7.getDatumAsString(), "Onbekend");

        Datum datum8 = new Datum(29, 2, 1900);
        assertEquals(datum8.getDatumAsString(), "Onbekend");

        Datum datum9 = new Datum(29, 2, 2016);
        assertNotEquals(datum9.getDatumAsString(), "Onbekend");
    }
}