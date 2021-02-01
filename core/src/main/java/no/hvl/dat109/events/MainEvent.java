package no.hvl.dat109.events;

import lombok.Getter;
import no.hvl.dat109.spiller.Spiller;
import org.springframework.context.ApplicationEvent;

@Getter
public class MainEvent extends ApplicationEvent {

    private final Spiller spiller;

    /**
     * @param source  the object on which the event initially occurred or with
     *                which the event is associated (never {@code null})
     * @param spiller den spilleren hvor hendelsen inntraff
     */
    public MainEvent(Object source, Spiller spiller) {
        super(source);
        this.spiller = spiller;
    }
}
