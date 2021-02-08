package no.hvl.dat109.brett;

//public class BrettImpl implements Brett {
//
//    private final Rute[] ruter;
//
//    /**
//     * Konstruktøren oppretter eit brett med spesialruter allereie spesifisert i koden.
//     * Slik får vi same spillbrett kvar gong.
//     * Opprettar tabell med 101 indeksar og brukar ikkje indeks [0] slik at rutenummer stemmer overens med indeks.
//     */
//    public BrettImpl(){
//        ruter = new Rute[101];
//
//        for (int[] slange : Brett.slanger) {
//            ruter[slange[0]] = new SpesialRuteImpl(SpesialRute.Type.SLANGE, slange[1]);
//        }
//
//        for (int[] stige : Brett.stiger) {
//            ruter[stige[0]] = new SpesialRuteImpl(SpesialRute.Type.STIGE, stige[1]);
//        }
//    }
//
//    @Override
//    public Rute getRute(int posisjon) {
//        return ruter[posisjon];
//    }
//}
