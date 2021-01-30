package no.hvl.dat109.spiller;

import lombok.extern.slf4j.Slf4j;
import no.hvl.dat109.Terning;

@Slf4j
public class SpillerMedHjerne implements Spiller {

    private final Hjerne hjerne;
    private final Brikke brikke;

    public SpillerMedHjerne() {
        brikke = new BrikkeImpl();
        hjerne = new Hjerne();
    }

    @Override
    public void spillTur(Terning terning) {
        int oyne;
        int nyPosisjon;
        do {
            oyne = kastTerning(terning);
            nyPosisjon = hjerne.hvorTil(brikke.getPosisjon(), oyne);
            if (nyPosisjon != -1) flyttBrikke(nyPosisjon);
        } while (hjerne.kanKastePaNytt(nyPosisjon, oyne));
    }

    private void flyttBrikke(int posisjon) {
        brikke.setPosisjon(posisjon);
    }

    private int kastTerning(Terning terning) {
        return terning.trill();
    }

    @Override
    public boolean harVunnet() {
        return brikke.getPosisjon() == 100;
    }
}
