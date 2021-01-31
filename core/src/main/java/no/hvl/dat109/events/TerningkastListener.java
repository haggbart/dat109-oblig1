package no.hvl.dat109.events;

import no.hvl.dat109.SpillController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TerningkastListener implements ApplicationListener<TerningkastEvent> {

    private final SpillController controller;

    @Autowired
    public TerningkastListener(SpillController controller) {
        this.controller = controller;
    }

    @Override
    public void onApplicationEvent(TerningkastEvent event) {
        controller.onTerningKastet(event.getTerning());
    }
}
