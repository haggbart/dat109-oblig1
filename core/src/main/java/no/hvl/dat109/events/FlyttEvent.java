package no.hvl.dat109.events;

import lombok.Getter;
import no.hvl.dat109.brett.SpesialRute;
import org.springframework.context.ApplicationEvent;

@Getter
public class FlyttEvent extends ApplicationEvent {

    private final int posisjon;
    private final SpesialRute rute;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public FlyttEvent(Object source, int posisjon, SpesialRute rute) {
        super(source);
        this.posisjon = posisjon;
        this.rute = rute;
    }
}
