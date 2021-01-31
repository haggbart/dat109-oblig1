package no.hvl.dat109.events;

import lombok.Getter;
import no.hvl.dat109.spiller.Brikke;
import org.springframework.context.ApplicationEvent;

public class FlyttEvent extends ApplicationEvent {

    @Getter
    private final Brikke brikke;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public FlyttEvent(Object source, Brikke brikke) {
        super(source);
        this.brikke = brikke;
    }
}
