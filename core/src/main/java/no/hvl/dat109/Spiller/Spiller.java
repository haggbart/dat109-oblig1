package no.hvl.dat109.Spiller;

import no.hvl.dat109.Terning;
import no.hvl.dat109.brett.Brett;
import no.hvl.dat109.brett.Rute;

public interface Spiller {

    int kastTerning(Terning terning);
    Rute flyttBrikke(Brett brett, int posisjon);
}
