package no.hvl.dat109;

import lombok.extern.slf4j.Slf4j;
import no.hvl.dat109.spiller.Spiller;

@Slf4j
public class StigespillImpl implements Stigespill {

    private final Terning terning;
    private final Koe koe;

    public StigespillImpl(int antallSpillere) {
        terning = new TerningImpl();
        koe = new KoeQueue(antallSpillere);
    }

    @Override
    public void start() {
        log.debug("Spill startet");
        Spiller spiller;

         do {
            spiller = koe.neste();
            spiller.spillTur(terning);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!spiller.harVunnet());

        log.debug("Spiller {} har vunnet spillet!", spiller);
    }
}
