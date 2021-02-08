package no.hvl.dat109.brett;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class BrettImpl2 implements Brett {

    private final Map<Integer, Rute> ruter;
    private final ApplicationContext context;

    public BrettImpl2(ApplicationContext context) {
        this.context = context;
        this.ruter = new HashMap<>(100);
        genererSpesialruter();
    }

    private void genererSpesialruter() {
        for (int[] rute : stiger) {
            SpesialRute spesialRute = context.getBean(SpesialRute.class);
            spesialRute.setType(SpesialRute.Type.STIGE);
            spesialRute.setLink(rute[1]);
            ruter.put(rute[0], spesialRute);

//            ruter.put(rute[0], new SpesialRuteImpl(SpesialRute.Type.STIGE, rute[1]));
        }

        for (int[] rute : slanger) {
            SpesialRute spesialRute = context.getBean(SpesialRute.class);
            spesialRute.setType(SpesialRute.Type.SLANGE);
            spesialRute.setLink(rute[1]);
            ruter.put(rute[0], spesialRute);
//            ruter.put(rute[0], new SpesialRuteImpl(SpesialRute.Type.SLANGE, rute[1]));
        }
    }

    @Override
    public Rute getRute(int posisjon) {
        return ruter.get(posisjon);
    }
}
