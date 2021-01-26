package no.hvl.dat109.spiller;

import no.hvl.dat109.Terning;
import no.hvl.dat109.brett.Brett;
import no.hvl.dat109.brett.Rute;

public class SpillerImpl implements Spiller {

    private Brikke brikke;


    //Triller terning
    @Override
    public int kastTerning(Terning terning) {

        return terning.trill();

    }


    //Oppdaterer posisjon på brikken og returnerer nye ruten
    @Override
    public Rute flyttBrikke(Brett brett, int posisjon) {

        brikke.setPosisjon(posisjon);
        return brett.getRute(posisjon);

    }
}
