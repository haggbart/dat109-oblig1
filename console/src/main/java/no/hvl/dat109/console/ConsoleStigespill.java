package no.hvl.dat109.console;

import lombok.extern.slf4j.Slf4j;
import no.hvl.dat109.Spill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ConsoleStigespill {

    private final Spill spill;

    @Autowired
    public ConsoleStigespill(Spill spill) {
        this.spill = spill;
    }

    @EventListener(ContextStartedEvent.class)
    public void start() {
        spill.start();
    }

    public void print(String melding) {
        System.out.println(melding);
    }
}
