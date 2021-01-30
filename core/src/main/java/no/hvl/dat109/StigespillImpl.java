package no.hvl.dat109;

import lombok.extern.slf4j.Slf4j;
import no.hvl.dat109.config.AntallSpillere;
import no.hvl.dat109.spiller.Spiller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StigespillImpl implements Stigespill {

    private final Terning terning;
    private final Koe koe;

    @Autowired
    public StigespillImpl(Terning terning, @AntallSpillere int antallSpillere) {
        this.terning = terning;
        koe = new KoeArray(antallSpillere);
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
            log.debug("-------------------------------");
        } while (!spiller.harVunnet());

        log.debug("Spiller {} har vunnet spillet!", spiller);
    }
}
