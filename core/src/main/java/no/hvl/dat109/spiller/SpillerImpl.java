package no.hvl.dat109.spiller;

import no.hvl.dat109.Terning;
import no.hvl.dat109.brett.Rute;
import no.hvl.dat109.brett.SpesialRute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.System.exit;

public class SpillerImpl implements Spiller {

    private final Brikke brikke;
    private final boolean trenger6;
    private int terningTeller;

    public SpillerImpl() {

        brikke = new BrikkeImpl();
        trenger6 = false;
    }

    //Triller terning
    private int kastTerning(Terning terning) {
        log.debug("{} kaster terning", this);
        return terning.trill();
    }

    //Oppdaterer posisjon på brikken og returnerer nye ruten

    private Rute flyttBrikke(int posisjon) {
        log.debug("{} flytter brikke", this);
        brikke.setPosisjon(posisjon);
        return brikke.getRute(posisjon);
    }


    @Override
    public void spillTur(Terning terning) {
        // kaste terning
        int terningkast = kastTerning(terning);

        if (terningkast >= 1) {
            int nyPosisjon = brikke.getPosisjon() + terningkast;
            Rute rute = flyttBrikke(nyPosisjon);
            harVunnet = sjekkOmSpillerHarVunnet(nyPosisjon);
            sjekkRute(rute);
        }

        if (terningkast == 6) {
            trenger6 = false;
            nyttKast(terning);
        }

        terningTeller = 0;
    }

    /**
     * Triller terning
     * Sjekker om spelar må trille 6 for å flytte.
     *
     * @param terning som skal trillast
     * @return terningkast-verdi eller -1 dersom spelar ikkje får lov å flytte.
     */
    private int kastTerning(Terning terning) {
        log.debug("{} kaster terning", this);
        int terningkast = terning.trill();

        if (trenger6 && terningkast != 6) {
            log.debug("{} må trille 6 for å flytte", this);
            return -1;
        }

        return terningkast;
    }

    /**
     * Oppdaterer posisjon på brikka og returnerer den nye ruta.
     * Sjekker om posisjon er over 100, då får spelar ikkje lov å flytte.
     *
     * @param nyPosisjon indeksen til ny posisjon
     * @return ruta som spelaren står på
     */
    private Rute flyttBrikke(int nyPosisjon) {
        if (nyPosisjon > 100) {
            log.debug("{} : flytting avvist (over 100)", this);
        } else {
            log.debug("{} flytter brikke", this);
            brikke.setPosisjon(nyPosisjon);
        }
        return brikke.getRute(brikke.getPosisjon());
    }


    /**
     * Sjekker om spelar står på posisjon 100 (MÅL).
     * @param posisjon spelaren sin posisjon
     * @return true om spelaren har vunnet, false elles
     */
    private boolean sjekkOmSpillerHarVunnet(int posisjon) {
        return posisjon == 100;
    }


    /**
     * Sjekker om rute er spesialrute, dvs. om det er ein stige eller slange assossiert med ruta.
     * Flytter brikke dersom ruta er ei spesialrute.
     * @param rute ruta som skal sjekkast
     */
    private void sjekkRute(Rute rute) {
        if (rute instanceof SpesialRute) {
            SpesialRute spesialRute = ((SpesialRute) rute);
            SpesialRute.Type type = spesialRute.getType();
            log.debug("var en spesialrute av type: {}", type);
            flyttBrikke(spesialRute.getLink());
        }
    }

    /**
     * Lar spelar kaste terning på nytt dersom han trilte 6.
     * Har kontroll på kor mange gongar spelar har trilla 6 på rad.
     * Dersom spelar triller 6 tre gongar på rad, må han tilbake til start og må trille 6 for å flytte igjen.
     *
     * @param terning terning som skal trillast
     */
    private void nyttKast(Terning terning) {
        terningTeller++;
        if (terningTeller == 3) {
            log.debug("Spiller {} må flytte tilbake til start (6x3)", this);
            flyttBrikke(1);
            trenger6 = true;
            terningTeller = 0;
            return;
        }
        log.debug("Spiller {} får trille på nytt", this);
        spillTur(terning);
    }

    @Override
    public boolean harVunnet() {
        return harVunnet;
    }

    @Override
    public String toString() {
        return hashCode() + "";
    }
}
