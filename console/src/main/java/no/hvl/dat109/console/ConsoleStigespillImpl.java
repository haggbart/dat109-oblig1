package no.hvl.dat109.console;

import lombok.extern.slf4j.Slf4j;
import no.hvl.dat109.Spill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ConsoleStigespillImpl implements ConsoleStigespill {

    private final Spill spill;

    @Autowired
    public ConsoleStigespillImpl(Spill spill) {
        this.spill = spill;
    }

    @Override
    public void start() {
        spill.start();
    }

    @Override
    public void print(String melding) {
        System.out.println(melding);
    }
}
