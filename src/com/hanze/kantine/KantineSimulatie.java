package com.hanze.kantine;

public class KantineSimulatie {

    private static Kantine kantine;

    public static final int DAGEN = 7;

    /**
     * Constructor
     */
    public KantineSimulatie() {
        kantine = new Kantine();
    }

    /**
     * Deze methode simuleert een aantal dagen in het
     * verloop van de kantine
     *
     * @param dagen
     */
    public void simuleer(int dagen) {
        for(int dag = 0;  dag < dagen; dag++) {
            int aantalPersonen = 10 + dag;

            for(int i = 0; i != aantalPersonen; i++) {
                kantine.loopPakSluitAan();
            }

            kantine.verwerkRijVoorKassa();

            System.out.printf("--------------- Dag: %d ---------------\n", dag);
            System.out.printf("Aantal artikelen verkocht deze dag: %d\n", kantine.getKassa().getAantalArtikelen());
            System.out.printf("Totale omzet deze dag: \u20ac%.2f\n", kantine.getKassa().hoeveelheidGeldInKassa());

            kantine.resetKassa();
        }
    }

    /**
     * Start een simulatie
     */
    public static void main(String[] args) {
        int dagen;

        if (args.length == 0) {
            dagen = DAGEN;
        } else {
            dagen = Integer.parseInt(args[0]);
        }

        new KantineSimulatie().simuleer(dagen);
    }
}