package no.hvl.dat109.spiller;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Hjerne {

    int seksPaRad;
    boolean maHaSeks;

    public int hvorTil(int posisjon, int oyne) {
        if (fikkSeksPaRad(oyne)) {
            log.debug("kastet 6 3 ganger på rad");
            maHaSeks = true;
            seksPaRad = 0;
            return 1;
        }
        if (!kanFlytte(posisjon, oyne)) {
            return -1;
        }

        return posisjon + oyne;
    }

    private boolean fikkSeksPaRad(int oyne) {
        if (oyne != 6) seksPaRad = 0;
        return oyne == 6 && ++seksPaRad == 3;
    }

    private boolean kanFlytte(int posisjon, int oyne) {
        if (maHaSeks) {
            if (oyne == 6) {
                log.debug("må ikke lenger ha 6");
                maHaSeks = false;
            } else {
                seksPaRad = 0;
            }
            return false;
        }

        return posisjon + oyne <= 100;
    }

    public boolean kanKastePaNytt(int nyPosisjon, int oyne) {
        return nyPosisjon != 100 && oyne == 6 && !maHaSeks;
    }
}
