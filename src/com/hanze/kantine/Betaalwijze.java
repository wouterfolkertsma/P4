package com.hanze.kantine;

/**
 * Author Wouter Folkertsma
 * Datum 15-05-2019
 */
public abstract class Betaalwijze {

    protected double saldo;

    /**
     * Methode om krediet te initialiseren
     * @param saldo
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Methode om betaling af te handelen
     *
     * @param tebetalen
     * @return Boolean om te kijken of er voldoende saldo is
     */
    public abstract boolean betaal(double tebetalen);
}