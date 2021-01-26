package no.hvl.dat109;

import no.hvl.dat109.spiller.Spiller;
import no.hvl.dat109.spiller.SpillerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Queue;

public class KoeQueue implements Koe {

    private static final Logger log = LoggerFactory.getLogger(Koe.class);

    private final Queue<Spiller> spillere;
    private Spiller aktuellSpiller;

    public KoeQueue(int antallSpillere) {

        spillere = new ArrayDeque<>(antallSpillere);

        for (int i = 0; i < antallSpillere; i++) {
            spillere.add(new SpillerImpl());
        }

        aktuellSpiller = spillere.remove();
    }

    @Override
    public Spiller neste() {
        spillere.add(aktuellSpiller);
        aktuellSpiller = spillere.remove();
        log.debug("neste spiller: {}", aktuellSpiller);
        return aktuellSpiller;
    }
}
