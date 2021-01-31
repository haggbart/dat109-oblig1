package no.hvl.dat109.console;

import lombok.extern.slf4j.Slf4j;
import no.hvl.dat109.config.SpillConfig;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info("Stigespillet");

        // lag kontekst (container)
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(SpillConfig.class);

        // start kontekst
        context.start();

        // lukk kontekst (container)
        context.close();
    }
}
