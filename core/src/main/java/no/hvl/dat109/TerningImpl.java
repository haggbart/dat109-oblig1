package no.hvl.dat109;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import no.hvl.dat109.events.TerningkastEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.Random;

@Slf4j
@Component
public class TerningImpl implements Terning {

    private final ApplicationEventPublisher publisher;
    private final static Random random = new Random();

    @Getter
    private int oyne;

    @Autowired
    public TerningImpl(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public int trill() {
        oyne = random.nextInt(6) + 1;
        log.debug("terning trillet: verdi = {}", oyne);
        onTerningKastet(this);
        return oyne;
    }
    private void onTerningKastet(Terning terning) {
        TerningkastEvent terningkastEvent = new TerningkastEvent(this, terning);
        publisher.publishEvent(terningkastEvent);
    }
}
