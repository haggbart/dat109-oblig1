package no.hvl.dat109.spiller;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import no.hvl.dat109.brett.Brett;
import no.hvl.dat109.brett.Rute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BrikkeImpl implements Brikke {

    @Getter
    @Setter
    private int posisjon;

    private final Brett brett;

    @Autowired
    public BrikkeImpl(@Qualifier("mapBrett") Brett brett) {
        this.brett = brett;
        this.posisjon = 1;
    }

    public Rute getRute(int posisjon) {
        return brett.getRute(posisjon);
    }
}
