package no.hvl.dat109.spiller;

public interface Hjerne {

    /**
     * Beregner hvor spilleren kan flytte til basert på nåværende posisjon og resultat av terningkast.
     * @param posisjon spillerens posisjon
     * @param oyne antall øyne spilleren fikk på terningen
     * @return ny posisjon spilleren kan flytte til, -1 dersom spiller ikke kan flytte
     */
    int hvorTil(int posisjon, int oyne);

    /**
     * Bestemmer om spiller får lov til å kaste terning på nytt.
     * @param nyPosisjon den nye posisjonen spilleren står på
     * @param oyne antall øyne spillern fikk på terningen
     * @return true dersom spiller kan kaste på nytt
     */
    boolean kanKastePaNytt(int nyPosisjon, int oyne);
}
