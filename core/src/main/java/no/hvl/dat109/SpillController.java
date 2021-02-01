package no.hvl.dat109;

import no.hvl.dat109.brett.SpesialRute;
import no.hvl.dat109.spiller.Spiller;
import org.springframework.stereotype.Repository;

@Repository
public interface SpillController {

    /**
     *
     * @param terning terningen som ble kastet
     */
    void onTerningKastet(Terning terning);

    /**
     *
     * @param posisjon posisjonen brikken flyttes til
     * @param rute ruten brikken ble flyttet til
     */
    void onBrikkeFlyttes(int posisjon, SpesialRute rute);

    /**
     *
     * @param spiller den spilleren hvor hendelsen inntraff
     */
    void onMainEvent(Spiller spiller);
}
