package no.hvl.dat109;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import no.hvl.dat109.spiller.Spiller;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KoeArray implements Koe {

    private int teller;

    @Setter
    private Spiller[] spillere;

    @Override
    public Spiller neste() {
        Spiller spiller = spillere[teller = (teller + 1) % (spillere.length)];
        log.debug("neste spiller: {}", spiller);
        return spiller;
    }
}
