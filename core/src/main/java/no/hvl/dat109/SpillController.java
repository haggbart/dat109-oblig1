package no.hvl.dat109;

import no.hvl.dat109.spiller.Brikke;
import no.hvl.dat109.spiller.Spiller;
import org.springframework.stereotype.Repository;

@Repository
public interface SpillController {

    void onTerningKastet(Terning terning);

    void onBrikkeFlyttes(Brikke brikke);

    void onMainEvent(Spiller spiller);
}
