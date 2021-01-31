package no.hvl.dat109.brett;

import org.springframework.stereotype.Component;

@Component("brettImpl")
public class BrettImpl implements Brett {

    private final Rute[] ruter;

    /**
     * Konstruktøren oppretter eit brett med spesialruter allereie spesifisert i koden.
     * Slik får vi same spillbrett kvar gong.
     * Opprettar tabell med 101 indeksar og brukar ikkje indeks [0] slik at rutenummer stemmer overens med indeks.
     */
    public BrettImpl(){
        ruter = new Rute[101];

        SpesialRute.Type stige = SpesialRute.Type.STIGE;
        ruter[2] = new SpesialRuteImpl(stige, 37);
        ruter[7] = new SpesialRuteImpl(stige, 28);
        ruter[12] = new SpesialRuteImpl(stige, 31);
        ruter[21] = new SpesialRuteImpl(stige, 85);
        ruter[26] = new SpesialRuteImpl(stige, 47);
        ruter[41] = new SpesialRuteImpl(stige, 61);
        ruter[48] = new SpesialRuteImpl(stige, 66);
        ruter[50] = new SpesialRuteImpl(stige, 70);
        ruter[69] = new SpesialRuteImpl(stige, 71);
        ruter[83] = new SpesialRuteImpl(stige, 97);

        SpesialRute.Type slange = SpesialRute.Type.SLANGE;
        ruter[35] = new SpesialRuteImpl(slange, 13);
        ruter[38] = new SpesialRuteImpl(slange, 6);
        ruter[57] = new SpesialRuteImpl(slange, 15);
        ruter[62] = new SpesialRuteImpl(slange, 43);
        ruter[67] = new SpesialRuteImpl(slange, 53);
        ruter[93] = new SpesialRuteImpl(slange, 74);
        ruter[96] = new SpesialRuteImpl(slange, 55);
        ruter[99] = new SpesialRuteImpl(slange, 78);
    }

    @Override
    public Rute getRute(int posisjon) {
        return ruter[posisjon];
    }
}
