package no.hvl.dat109.spiller;

public class BrikkeImpl implements Brikke {

    private int posisjon;

    @Override
    public int getPosisjon() {

    return posisjon;

    }

    @Override
    public void setPosisjon(int posisjon) {

        this.posisjon = posisjon;

    }
}
