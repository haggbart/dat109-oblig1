package no.hvl.dat109.spiller;

import no.hvl.dat109.Terning;
import no.hvl.dat109.brett.Brett;
import no.hvl.dat109.brett.Rute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpillerImpl implements Spiller {

    private static final Logger log = LoggerFactory.getLogger(Spiller.class);

    private Brikke brikke;

    //Triller terning
    @Override
    public int kastTerning(Terning terning) {

        log.debug("{} kaster terning", this);
        return terning.trill();
    }


    //Oppdaterer posisjon på brikken og returnerer nye ruten
    @Override
    public Rute flyttBrikke(Brett brett, int posisjon) {

        log.debug("{} flytter brikke", this);
        brikke.setPosisjon(posisjon);
        return brett.getRute(posisjon);
    }

    @Override
    public String toString() {
        return this.hashCode() + "";
    }
}
