package no.hvl.dat109;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class TerningImpl implements Terning {


    private final static Logger log = LoggerFactory.getLogger(Terning.class);

    private final static Random random = new Random();

    @Override
    public int trill() {
        int verdi = random.nextInt(6) + 1;
        log.debug("terning trillet: verdi = {}", verdi);

        return verdi;
    }
}
