package no.hvl.dat109;

import no.hvl.dat109.spiller.Spiller;

public interface Koe {

    /**
     *
     * @return den neste spelaren i køa
     */
    Spiller neste();

    /**
     *
     * @param spillere spillerne som inngår i køen
     */
    void setSpillere(Spiller[] spillere);
}
