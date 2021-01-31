package no.hvl.dat109;

import lombok.extern.slf4j.Slf4j;
import no.hvl.dat109.brett.Brett;
import no.hvl.dat109.config.AntallSpillere;
import no.hvl.dat109.events.MainEvent;
import no.hvl.dat109.spiller.Spiller;
import no.hvl.dat109.spiller.SpillerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SpillImpl implements Spill {

    private final ApplicationEventPublisher publisher;
    private final Brett brett;
    private final Terning terning;
    private final Koe koe;

    @Autowired
    public SpillImpl(ApplicationEventPublisher publisher,
                     @Qualifier("mapBrett") Brett brett,
                     Terning terning,
                     Koe koe,
                     @AntallSpillere int antallSpillere) {
        this.publisher = publisher;
        this.brett = brett;
        this.terning = terning;
        this.koe = koe;

        genererSpillere(antallSpillere);
    }

    private void genererSpillere(int antallSpillere) {
        Spiller[] spillere = new Spiller[antallSpillere];
        for (int i = 0; i < antallSpillere; i++) {
            spillere[i] = new SpillerImpl(brett, publisher);
        }
        koe.setSpillere(spillere);
    }

    @Override
    public void start() {
        log.debug("Spill startet");
        Spiller spiller;

        do {
            spiller = koe.neste();
            publisher.publishEvent(new MainEvent(this, spiller, false));
            spiller.spillTur(terning);
            log.debug("-------------------------------");
        } while (!spiller.harVunnet());
        publisher.publishEvent(new MainEvent(this, spiller, true));
        log.info("Stigespillet er slutt");
    }
}
