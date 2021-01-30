package no.hvl.dat109.spiller;

import no.hvl.dat109.brett.Rute;

public interface Brikke {

    /**
     *
     * @return posisjoen til brikka
     */
    int getPosisjon();

    /**
     * Oppdaterer posisjonen til brikka
     * @param posisjon ny posisjon
     */
    void setPosisjon(int posisjon);

    /**
     *
     * @param posisjon 'rutenummeret'
     * @return ruta som er assosiert med rutenummeret
     */
    Rute getRute(int posisjon);
}
