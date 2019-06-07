package com.hanze.kantine;

public class Pinpas extends Betaalwijze {

    private double kredietlimiet;

    /**
     * Methode om kredietlimiet te zetten
     * @param kredietlimiet
     */
    public void setKredietLimiet(double kredietlimiet) {
        this.kredietlimiet = kredietlimiet;
    }

    /**
     * Methode om betaling af te handelen
     */
    public void betaal(double tebetalen) throws TeWeinigGeldException {
        if(kredietlimiet >= tebetalen) {
            kredietlimiet -= tebetalen;
            return;
        }

        throw new TeWeinigGeldException();
    }
}
