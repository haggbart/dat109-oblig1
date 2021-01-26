package no.hvl.dat109.spiller;

import no.hvl.dat109.Terning;
import no.hvl.dat109.brett.Rute;
import no.hvl.dat109.brett.SpesialRute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.System.exit;

public class SpillerImpl implements Spiller {

    private static final Logger log = LoggerFactory.getLogger(Spiller.class);

    private final Brikke brikke;
    private final boolean trenger6;
    private int terningTeller;

    public SpillerImpl() {

     brikke = new BrikkeImpl();
     trenger6 = false;
    }

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
    public void spillTur (Terning terning) {
        // kaste terning
        int terningkast = kastTerning(terning);
        int posisjon = brikke.getPosisjon();

        if (trenger6 && terningkast != 6) {
            log.debug("{} må trille 6 for å flytte", this);
        }

        // flytt brikke

        if (posisjon > 100) {
            log.debug("{} : flytting avvist (over 100)", this);
            return;
        }


        // sjekk om spesialrute
        Rute rute = flyttBrikke(nyPos);

        if (rute instanceof SpesialRute) {
            SpesialRute spesialRute = ((SpesialRute) rute);
            SpesialRute.Type type = spesialRute.getType();
            log.debug("var en spesialrute av type: {}", type);
            flyttBrikke(spesialRute.getLink());
            exit(0);
        }
    }

    /*
    spilltur:

     */

    @Override
    public String toString() {
        return hashCode() + "";
    }
}
