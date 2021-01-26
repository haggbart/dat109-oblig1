package no.hvl.dat109.spiller;

import no.hvl.dat109.Terning;
import no.hvl.dat109.brett.Rute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpillerImpl implements Spiller {

    private static final Logger log = LoggerFactory.getLogger(Spiller.class);

    private Brikke brikke;
    private boolean trenger6;

    //Triller terning
    private int kastTerning(Terning terning) {
        log.debug("{} kaster terning", this);
        return terning.trill();
    }

    //Oppdaterer posisjon på brikken og returnerer nye ruten

    private Rute flyttBrikke(int posisjon) {
        log.debug("{} flytter brikke", this);
        brikke.setPosisjon(posisjon);
        return brikke.getRute(posisjon);
    }

    @Override
    public Rute spillTur (Terning terning) {
        int terningkast = kastTerning(terning);
        int posisjon = brikke.getPosisjon();

        if (trenger6 && terningkast != 6) {
            log.debug("{} må trille 6 for å flytte", this);
            return brikke.getRute(posisjon);
        }

        int nyPos = posisjon + terningkast;
        if (nyPos > 100) {
            log.debug("{} : flytting avvist (over 100)", this);
        } else {
            return flyttBrikke(nyPos);
        }

        return null;
    }

    @Override
    public String toString() {
        return hashCode() + "";
    }
}
