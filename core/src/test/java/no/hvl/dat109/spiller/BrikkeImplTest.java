package no.hvl.dat109.spiller;

public class BrikkeImplTest extends BrikkeTest {

    @Override
    protected Brikke createInstance() {
        return new BrikkeImpl(null);
    }
}
