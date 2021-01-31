package no.hvl.dat109.console;

import no.hvl.dat109.SpillController;
import no.hvl.dat109.Terning;
import no.hvl.dat109.brett.SpesialRute;
import no.hvl.dat109.spiller.Spiller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpillControllerImpl implements SpillController {

    private final ConsoleStigespill console;
    private Spiller spiller;


    @Autowired
    public SpillControllerImpl(ConsoleStigespill console) {
        this.console = console;
    }


    // == hooks ==

    @Override
    public void onTerningKastet(Terning terning) {
        console.print(String.format("%s trillet %s", spiller, terning.getOyne()));
        sleep(1);
    }

    @Override
    public void onBrikkeFlyttes(int posisjon, SpesialRute rute) {
        console.print(String.format("%s flytter til rute %d", spiller, posisjon));
        if (rute != null) {
            sleep(2);
            console.print(String.format("%s landet på en %s!", spiller, rute.getType().toString().toLowerCase()));
        }
        sleep(2);
    }

    @Override
    public void onMainEvent(Spiller spiller) {
        if (spiller.harVunnet()) {
            console.print(String.format("%s har vunnet!", spiller));
            return;
        }
        this.spiller = spiller;
        console.print(String.format("""
                --------------------------
                                
                                
                
                --------------------------               
                 > %s sin tur til å spille 
                --------------------------""", spiller));
        sleep(2);
    }

    private void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
