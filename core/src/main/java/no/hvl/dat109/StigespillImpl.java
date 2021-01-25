package no.hvl.dat109;

import no.hvl.dat109.spiller.Spiller;
import no.hvl.dat109.brett.Brett;

public class StigespillImpl implements Stigespill {

    private Terning terning;
    private Spiller[] spillere;
    private Brett brett;


    @Override
    public void start(int antallSpillere, int antallRuter) {
        Spiller spiller = spillere[1];
    }
}
