package com.hanze.kantine;

import java.util.*;

public class KantineSimulatie {

    // kantine
    private Kantine kantine;

    // kantineaanbod
    private KantineAanbod kantineaanbod;

    // random generator
    private Random random;

    // aantal artikelen
    private static final int AANTAL_ARTIKELEN = 4;

    // artikelen
    private static final String[] artikelnamen = new String[]
            {"Koffie", "Broodje pindakaas", "Broodje kaas", "Appelsap"};

    //Instituut voor Communicatie, Media & IT 15
    //Project Kantine:Deel 1 2018 – 2019
      //      21 // prijzen
       //     22
    private static double[] artikelprijzen = new double[]{1.50, 2.10,
            1.65, 1.65};

    // minimum en maximum aantal artikelen per soort
    public static final int MIN_ARTIKELEN_PER_SOORT = 10;
    public static final int MAX_ARTIKELEN_PER_SOORT = 20;

    // minimum en maximum aantal personen per dag
    private static final int MIN_PERSONEN_PER_DAG = 50;
    private static final int MAX_PERSONEN_PER_DAG = 100;
    // minimum en maximum artikelen per persoon
    private static final int MIN_ARTIKELEN_PER_PERSOON = 1;
    private static final int MAX_ARTIKELEN_PER_PERSOON = 4;

    /**
     * 37 * Constructor
     * 38 *
     * 39
     */
    public KantineSimulatie() {
        kantine = new Kantine();
        random = new Random();
        int[] hoeveelheden = getRandomArray(
                AANTAL_ARTIKELEN,
                MIN_ARTIKELEN_PER_SOORT,
                MAX_ARTIKELEN_PER_SOORT);
        kantineaanbod = new KantineAanbod(
                artikelnamen, artikelprijzen, hoeveelheden);

        kantine.setKantineAanbod(kantineaanbod);
    }

    /**
     * 54 * Methode om een array van random getallen liggend tussen
     * 55 * min en max van de gegeven lengte te genereren
     * 56 *
     * 57 * @param lengte
     * 58 * @param min
     * 59 * @param max
     * 60 * @return De array met random getallen
     * 61
     */
    private int[] getRandomArray(int lengte, int min, int max) {
        //Instituut voor Communicatie, Media & IT 16
        //Project Kantine: Deel 1 2018 – 2019
        int[] temp = new int[lengte];
        for (int i = 0; i < lengte; i++) {
            temp[i] = getRandomValue(min, max);
        }

        return temp;
    }

    /**
     * 72 * Methode om een random getal tussen min(incl)
     * 73 * en max(incl) te genereren.
     * 74 *
     * 75 * @param min
     * 76 * @param max
     * 77 * @return Een random getal
     * 78
     */
    private int getRandomValue(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * 84 * Methode om op basis van een array van indexen voor de array
     * 85 * artikelnamen de bijhorende array van artikelnamen te maken
     * 86 *
     * 87 * @param indexen
     * 88 * @return De array met artikelnamen
     * 89
     */
    private String[] geefArtikelNamen(int[] indexen) {
        String[] artikelen = new String[indexen.length];
        for (int i = 0; i < indexen.length; i++) {
            artikelen[i] = artikelnamen[indexen[i]];

        }

        return artikelen;
    }

    /**
     * 102 * Deze methode simuleert een aantal dagen
     * 103 * in het verloop van de kantine
     * 104 *
     * 105 * @param dagen
     * Instituut voor Communicatie, Media & IT 17
     * Project Kantine: Deel 1 2018 – 2019
     * 106
     */
    public void simuleer(int dagen) {

        ArrayList<Double> dagOmzetten = new ArrayList<>();
        ArrayList<Integer> dagArtikelen = new ArrayList<>();

        // for lus voor dagen
        for (int i = 0; i < dagen; i++) {

            // bedenk hoeveel personen vandaag binnen lopen
            int aantalpersonen = getRandomValue(MIN_PERSONEN_PER_DAG, MAX_PERSONEN_PER_DAG);

            // laat de personen maar komen...
            for (int j = 0; j < aantalpersonen; j++) {

                // maak persoon en dienblad aan, koppel ze
                // en bedenk hoeveel artikelen worden gepakt
                int aantalartikelen = getRandomValue(MIN_ARTIKELEN_PER_PERSOON, MAX_ARTIKELEN_PER_PERSOON);

                // genereer de "artikelnummers", dit zijn indexen
                // van de artikelnamen
                int[] tepakken = getRandomArray(
                        aantalartikelen, 0, AANTAL_ARTIKELEN - 1);

                // vind de artikelnamen op basis van
                // de indexen hierboven
                String[] artikelen = geefArtikelNamen(tepakken);

                // loop de kantine binnen, pak de gewenste
                // artikelen, sluit aan
                Persoon persoon = new Persoon("00000-0000", "Steve", "Jobs", new Datum(1,1,1990), 'm');
                kantine.loopPakSluitAan(persoon, artikelen);
            }

            // verwerk rij voor de kassa
            kantine.verwerkRijVoorKassa();

            System.out.printf("--------------- Dag: %d ---------------\n", i);
            System.out.printf("Aantal artikelen verkocht deze dag: %d\n", kantine.getKassa().getAantalArtikelen());
            System.out.printf("Totale omzet deze dag: \u20ac%.2f\n", kantine.getKassa().hoeveelheidGeldInKassa());

            dagOmzetten.add(kantine.getKassa().hoeveelheidGeldInKassa());
            dagArtikelen.add(kantine.getKassa().getAantalArtikelen());

            kantine.resetKassa();
        }

        System.out.println(Administratie.berekenGemiddeldeOmzet(dagOmzetten));
        System.out.println(Administratie.berekenGemiddeldAantal(dagArtikelen));
    }

    /**
     * Start een simulatie
     */
    public static void main(String[] args) {
        new KantineSimulatie().simuleer(7);
    }
}