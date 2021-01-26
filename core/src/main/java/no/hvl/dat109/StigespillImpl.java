package no.hvl.dat109;

import no.hvl.dat109.spiller.Spiller;
import no.hvl.dat109.brett.Brett;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StigespillImpl implements Stigespill {

    private static final Logger log = LoggerFactory.getLogger(Stigespill.class);


    private Terning terning;
    private Koe koe;
    private Brett brett;


    @Override
    public void start() {
        log.debug("Spill startet");
        Spiller spiller = koe.neste();
        spiller.spillTur(terning, brett);
    }
}
