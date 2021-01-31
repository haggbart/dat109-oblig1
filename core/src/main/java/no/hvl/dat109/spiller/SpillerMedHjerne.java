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
public class SpillerMedHjerne implements Spiller {

    private static final Faker faker = new Faker(new Locale("no_NO"));

    private final ApplicationEventPublisher publisher;
    private final Hjerne hjerne;
    private final Brikke brikke;
    private final String navn;


    public SpillerMedHjerne(Brett brett, ApplicationEventPublisher publisher) {
        this.brikke = new BrikkeImpl(brett);
        this.publisher = publisher;
        this.navn = faker.name().firstName();
        hjerne = new Hjerne();

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
        publisher.publishEvent(new FlyttEvent(this, brikke));
        SpesialRute rute = (SpesialRute) brikke.getRute(posisjon);
        if (rute != null) {
            System.out.println("er spesial: " + rute.getLink());
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
