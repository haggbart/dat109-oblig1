package no.hvl.dat109.events;

import no.hvl.dat109.SpillController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MainEventListener implements ApplicationListener<MainEvent> {

    private final SpillController controller;

    @Autowired
    public MainEventListener(SpillController controller) {
        this.controller = controller;
    }

    @Override
    public void onApplicationEvent(MainEvent event) {
        controller.onMainEvent(event.getSpiller());
    }
}
