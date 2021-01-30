package no.hvl.dat109.console;

import lombok.extern.slf4j.Slf4j;
import no.hvl.dat109.Stigespill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ConsoleStigespill {

    private final Stigespill stigespill;


    @Autowired
    public ConsoleStigespill(Stigespill stigespill) {
        log.info("console kjørt");
        this.stigespill = stigespill;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void start() {
        System.out.println("test");
        stigespill.start();
    }
}
