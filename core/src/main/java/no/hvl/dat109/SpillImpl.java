package no.hvl.dat109;

import lombok.extern.slf4j.Slf4j;
import no.hvl.dat109.config.AntallSpillere;
import no.hvl.dat109.events.MainEvent;
import no.hvl.dat109.spiller.Spiller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SpillImpl implements Spill {

    private final ApplicationContext context;
    private final ApplicationEventPublisher publisher;
    private final Terning terning;
    private final Koe koe;

    @Autowired
    public SpillImpl(ApplicationContext context,
                     ApplicationEventPublisher publisher,
                     Terning terning,
                     Koe koe,
                     @AntallSpillere int antallSpillere) {
        this.context = context;
        this.publisher = publisher;
        this.terning = terning;
        this.koe = koe;

        genererSpillere(antallSpillere);
    }

    private void genererSpillere(int antallSpillere) {
        Spiller[] spillere = new Spiller[antallSpillere];
        for (int i = 0; i < antallSpillere; i++) {
            spillere[i] = context.getBean(Spiller.class);
        }
        koe.setSpillere(spillere);
    }

    @Override
    public void start() {
        log.debug("Spill startet");
        Spiller spiller;

        do {
            spiller = koe.neste();
            onMainEvent(spiller);
            spiller.spillTur(terning);
            log.debug("-------------------------------");
        } while (!spiller.harVunnet());
        onMainEvent(spiller);
        log.info("Stigespillet er slutt");
    }
    
    private void onMainEvent(Spiller spiller) {
        publisher.publishEvent(new MainEvent(this, spiller));
    }
}
