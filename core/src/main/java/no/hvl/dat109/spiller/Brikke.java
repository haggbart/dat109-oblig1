package no.hvl.dat109.spiller;

import no.hvl.dat109.brett.Rute;

public interface Brikke {

    int getPosisjon();

    void setPosisjon(int posisjon);

    Rute getRute(int posisjon);
}
