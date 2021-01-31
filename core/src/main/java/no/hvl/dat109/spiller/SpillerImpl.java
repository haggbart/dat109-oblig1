package no.hvl.dat109.spiller;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import no.hvl.dat109.Terning;
import no.hvl.dat109.brett.Brett;
import no.hvl.dat109.brett.SpesialRute;
import no.hvl.dat109.events.FlyttEvent;
import org.springframework.context.ApplicationEventPublisher;

import java.util.Locale;

@Slf4j
public class SpillerImpl implements Spiller {

    // == fields ==

    private static final Faker faker = new Faker(new Locale("nb-NO"));

    private final ApplicationEventPublisher publisher;
    private final Hjerne hjerne;
    private final Brikke brikke;
    private final String navn;


    // == constructors ==

    public SpillerImpl(Brett brett, ApplicationEventPublisher publisher) {
        this.brikke = new BrikkeImpl(brett);
        this.publisher = publisher;
        this.navn = faker.name().firstName();
        hjerne = new HjerneImpl();
    }

    @Override
    public void spillTur(Terning terning) {
        int oyne;
        int nyPosisjon;
        do {
            oyne = kastTerning(terning);
            nyPosisjon = hjerne.hvorTil(brikke.getPosisjon(), oyne);
            if (nyPosisjon == -1) continue;
            flyttBrikke(nyPosisjon);
        } while (hjerne.kanKastePaNytt(nyPosisjon, oyne));
    }

    private void flyttBrikke(int posisjon) {
        brikke.setPosisjon(posisjon);
        SpesialRute rute = (SpesialRute) brikke.getRute(posisjon);
        publisher.publishEvent(new FlyttEvent(this, brikke, rute));
        if (rute != null) {
            flyttBrikke(rute.getLink());
        }
    }

    private int kastTerning(Terning terning) {
        return terning.trill();
    }

    @Override
    public boolean harVunnet() {
        return brikke.getPosisjon() == 100;
    }

    @Override
    public String toString() {
        return navn;
    }
}
