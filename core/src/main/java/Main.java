import no.hvl.dat109.Stigespill;
import no.hvl.dat109.StigespillImpl;

public class Main {

    public static void main(String[] args) {
        Stigespill spill = new StigespillImpl(1);
        spill.start();
    }
}
