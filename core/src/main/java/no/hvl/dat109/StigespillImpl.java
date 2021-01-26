package no.hvl.dat109;

import no.hvl.dat109.spiller.Spiller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StigespillImpl implements Stigespill {

    private static final Logger log = LoggerFactory.getLogger(Stigespill.class);


    private Terning terning;
    private Koe koe;

    public StigespillImpl(int antallSpillere) {

        terning = new TerningImpl();
        koe = new KoeQueue(antallSpillere);
    }

    @Override
    public void start() {
        log.debug("Spill startet");

        for (int i = 0; i < 100; i++) {
            Spiller spiller = koe.neste();
            spiller.spillTur(terning);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
