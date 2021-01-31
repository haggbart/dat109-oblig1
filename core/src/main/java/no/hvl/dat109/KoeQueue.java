package no.hvl.dat109;

import lombok.extern.slf4j.Slf4j;
import no.hvl.dat109.spiller.Spiller;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

@Slf4j
public class KoeQueue implements Koe {

    private Queue<Spiller> spillere;
    private Spiller aktuellSpiller;

    @Override
    public Spiller neste() {
        spillere.add(aktuellSpiller);
        aktuellSpiller = spillere.remove();
        log.debug("neste spiller: {}", aktuellSpiller);
        return aktuellSpiller;
    }

    @Override
    public void setSpillere(Spiller[] spillere) {
        this.spillere = new ArrayDeque<>(spillere.length);
        aktuellSpiller = spillere[0];
        this.spillere.addAll(Arrays.asList(spillere).subList(1, spillere.length));
    }
}
