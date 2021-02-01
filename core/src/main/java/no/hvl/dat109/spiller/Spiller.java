package no.hvl.dat109.spiller;

import no.hvl.dat109.Terning;

public interface Spiller {

    /**
     * Starter ny tur for spiller
     * @param terning spillets terning
     */
    void spillTur(Terning terning);

    /**
     *
     * @return true dersom spiller har vunnet spillet
     */
    boolean harVunnet();
}
