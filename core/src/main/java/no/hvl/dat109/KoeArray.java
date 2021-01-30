package no.hvl.dat109;

import no.hvl.dat109.spiller.Spiller;
import no.hvl.dat109.spiller.SpillerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KoeArray implements Koe {

    private final static Logger log = LoggerFactory.getLogger(Koe.class);

    private int teller;
    private final Spiller[] spillere;

    public KoeArray(int antallSpillere) {

        spillere = new Spiller[antallSpillere];

        for (int i = 0; i < antallSpillere; i++) {
            spillere[i] = new SpillerImpl();
        }
    }

    @Override
    public Spiller neste() {
        System.out.println(spillere.length);
        Spiller spiller = spillere[teller = (teller + 1) % (spillere.length)];
        log.debug("neste spiller: {}", spiller);
        return spiller;
    }
}
