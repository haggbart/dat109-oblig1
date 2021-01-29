package no.hvl.dat109.spiller;

import lombok.extern.slf4j.Slf4j;
import no.hvl.dat109.brett.Brett;
import no.hvl.dat109.brett.BrettImpl;
import no.hvl.dat109.brett.Rute;

@Slf4j
public class BrikkeImpl implements Brikke {

    private final Brett brett;
    private int posisjon;

    public BrikkeImpl() {
        brett = new BrettImpl();
        posisjon = 1;
    }

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
