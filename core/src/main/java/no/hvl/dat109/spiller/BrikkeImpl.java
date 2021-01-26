package no.hvl.dat109.spiller;

import no.hvl.dat109.brett.Brett;
import no.hvl.dat109.brett.Rute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrikkeImpl implements Brikke {


    private static final Logger log = LoggerFactory.getLogger(Brikke.class);

    private Brett brett;

    private int posisjon;

    @Override
    public int getPosisjon() {
        return posisjon;
    }

    @Override
    public void setPosisjon(int posisjon) {

        log.debug("posisjon satt til {}", posisjon);
        this.posisjon = posisjon;
    }

    public Rute getRute(int posisjon) {
        return brett.getRute(posisjon);
    }
}
