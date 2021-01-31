package no.hvl.dat109.events;

import no.hvl.dat109.SpillController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class FlyttEventListener implements ApplicationListener<FlyttEvent> {

    private final SpillController controller;

    @Autowired
    public FlyttEventListener(SpillController controller) {
        this.controller = controller;
    }

    @Override
    public void onApplicationEvent(FlyttEvent event) {
        controller.onBrikkeFlyttes(event.getPosisjon(), event.getRute());
    }
}
