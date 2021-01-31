package no.hvl.dat109.brett;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("mapBrett")
public class MapBrett implements Brett {

    private final Map<Integer, Rute> ruter;

    public MapBrett() {
        this.ruter = new HashMap<>(100);
        genererSpesialruter();
    }

    private void genererSpesialruter() {
        for (int[] rute : stiger) {
            ruter.put(rute[0], new SpesialRuteImpl(SpesialRute.Type.STIGE, rute[1]));
        }

        for (int[] rute : slanger) {
            ruter.put(rute[0], new SpesialRuteImpl(SpesialRute.Type.SLANGE, rute[1]));
        }
    }

    @Override
    public Rute getRute(int posisjon) {
        return ruter.get(posisjon);
    }
}
