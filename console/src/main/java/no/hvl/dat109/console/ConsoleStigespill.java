package no.hvl.dat109.console;

import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;

public interface ConsoleStigespill {

    @EventListener(ContextStartedEvent.class)
    void start();

    void print(String melding);
}
