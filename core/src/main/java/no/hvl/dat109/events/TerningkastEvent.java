package no.hvl.dat109.events;

import lombok.Getter;
import no.hvl.dat109.Terning;
import org.springframework.context.ApplicationEvent;

public class TerningkastEvent extends ApplicationEvent {

    @Getter
    private final Terning terning;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public TerningkastEvent(Object source, Terning terning) {
        super(source);
        this.terning = terning;
    }
}
