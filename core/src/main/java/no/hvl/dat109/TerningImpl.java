package no.hvl.dat109;

import lombok.extern.slf4j.Slf4j;
import java.util.Random;

@Slf4j
public class TerningImpl implements Terning {

    private final static Random random = new Random();

    @Override
    public int trill() {
        int verdi = random.nextInt(2) + 5;
        log.debug("terning trillet: verdi = {}", verdi);
        return verdi;
    }
}
