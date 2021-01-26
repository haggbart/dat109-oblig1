package no.hvl.dat109;

public class TerningTestImpl extends TerningTest {

    @Override
    protected Terning createInstance() {
        return new TerningImpl();
    }
}
