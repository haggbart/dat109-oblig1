package no.hvl.dat109;

import no.hvl.dat109.brett.SpesialRute;
import no.hvl.dat109.spiller.Spiller;
import org.springframework.stereotype.Repository;

@Repository
public interface SpillController {

    void onTerningKastet(Terning terning);

    void onBrikkeFlyttes(int posisjon, SpesialRute rute);

    void onMainEvent(Spiller spiller);
}
