package no.hvl.dat109.spiller;

import no.hvl.dat109.Terning;
import no.hvl.dat109.brett.Brett;
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
    private Rute flyttBrikke(Brett brett, int posisjon) {
        log.debug("{} flytter brikke", this);
        brikke.setPosisjon(posisjon);
        return brett.getRute(posisjon);
    }

    @Override
    public Rute spillTur (Terning terning, Brett brett) {
        int terningkast = kastTerning(terning);

        if (trenger6 && terningkast != 6) {
            log.debug("{} må trille 6 for å flytte", this);
            return brett.getRute(brikke.getPosisjon());
        }

        int nyPos = brikke.getPosisjon() + terningkast;
        if (nyPos > 100) {
            log.debug("{} : flytting avvist (over 100)", this);
        } else {
            return flyttBrikke(brett, nyPos);
        }

        return null;
    }

    @Override
    public String toString() {
        return hashCode() + "";
    }
}
