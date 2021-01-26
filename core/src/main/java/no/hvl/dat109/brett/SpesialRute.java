package no.hvl.dat109.brett;

public interface SpesialRute extends Rute {

    enum Type {
        STIGE,
        SLANGE,
    }

    Type getType();

    int getLink();
}
