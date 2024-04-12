package fi.arcada.projekt_chi2;

public class Significance {

    /**
     * Metod som räknar ut Chi-två på basis av fyra observerade värden (o1 - o4).
     */
    public static double chiSquared(int o1, int o2, int o3, int o4) {

        // Beräkna totala antalet observationer
        int totalObservations = o1 + o2 + o3 + o4;

        // Beräkna förväntade värden med hjälp av totala observationer och marginaler
        double totalRow1 = (double) (o1 + o2) / totalObservations;
        double totalRow2 = (double) (o3 + o4) / totalObservations;
        double totalCol1 = (double) (o1 + o3) / totalObservations;
        double totalCol2 = (double) (o2 + o4) / totalObservations;

        double e1 = totalRow1 * totalCol1 * totalObservations;
        double e2 = totalRow1 * totalCol2 * totalObservations;
        double e3 = totalRow2 * totalCol1 * totalObservations;
        double e4 = totalRow2 * totalCol2 * totalObservations;

        // Räkna ut Chi-två enligt formeln
        double chiSquared = Math.pow((o1 - e1), 2) / e1 +
                Math.pow((o2 - e2), 2) / e2 +
                Math.pow((o3 - e3), 2) / e3 +
                Math.pow((o4 - e4), 2) / e4;

        return chiSquared;
    }


    /**
     * Metod som tar emot resultatet från Chi-två-uträkningen
     * och returnerar p-värde enligt tabellen (en frihetsgrad)
     * (De mest extrema värdena har lämnats bort, det är ok för våra syften)
     *
     * exempel: getP(2.82) returnerar ett p-värde på 0.1
     *
     */
    public static double getP(double chiResult) {

        double p = 0.99;

        if (chiResult >= 1.642) p = 0.2;
        if (chiResult >= 2.706) p = 0.1;
        if (chiResult >= 3.841) p = 0.05;
        if (chiResult >= 5.024) p = 0.025;
        if (chiResult >= 5.412) p = 0.02;
        if (chiResult >= 6.635) p = 0.01;
        if (chiResult >= 7.879) p = 0.005;
        if (chiResult >= 9.550) p = 0.002;

        return p;

    }

}
