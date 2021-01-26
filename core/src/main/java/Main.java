import no.hvl.dat109.Koe;
import no.hvl.dat109.KoeArray;
import no.hvl.dat109.KoeQueue;

public class Main {


    // for enkel og kjapp testing / kladdeark
    public static void main(String[] args) {

        // Koe med array implementation:
        Koe arrayKoe = new KoeArray(4);


        for (int i = 0; i < 10; i++) {
            arrayKoe.neste();
        }
        System.out.println("---------");

        // Koe med Queue implementation:
        Koe queueKoe = new KoeQueue(4);


        for (int i = 0; i < 10; i++) {
            queueKoe.neste();
        }
    }
}
