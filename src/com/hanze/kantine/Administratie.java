package com.hanze.kantine;

import java.time.DayOfWeek;
import java.util.ArrayList;



public class Administratie {

    private static final int DAYS_IN_WEEK = 7;

    private Administratie(){ }


    /**
     * Deze methode berekent van de int array aantal de gemiddelde waarde
     *
     * @param aantal
     * @return double
     */
    public static double berekenGemiddeldAantal(ArrayList<Integer> aantal) {
        double total = 0;

        for (int getal : aantal) {
            total += getal;
        }

        return total / aantal.size();
    }

    /**
     * Deze methode berekent van de double array omzet de gemiddelde waarde
     *
     * @param omzet
     * @return het gemiddelde
     */
    public static double berekenGemiddeldeOmzet(ArrayList<Double> omzet) {
        double total = 0;

        for (double getal : omzet) {
            total += getal;
        }

        return total / omzet.size();
    }

    /**
     * Methode om dagomzet uit te rekenen
     *
     * @param omzet
     * @return array (7 elementen) met dagomzetten
     */

    public static double[] berekenDagOmzet(ArrayList<Double> omzet) {
        double[] temp = new double[7];

        for(int i = 0; i < DAYS_IN_WEEK; i++) {
            int j = 0;

            while(omzet.size() > i + DAYS_IN_WEEK * j) {
                temp[i] += omzet.get(i + DAYS_IN_WEEK * j);
                j++;
            }
        }
        return temp;
    }
}
