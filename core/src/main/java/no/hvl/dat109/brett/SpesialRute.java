package no.hvl.dat109.brett;

public interface SpesialRute extends Rute {

    /**
     * Dei ulike typar spesialruter
     */
    enum Type {
        STIGE,
        SLANGE,
    }

    /**
     *
     * @return typen til ruta
     */
    Type getType();

    /**
     * Link er assosiert med ruta som er i enden av stigen/slangen.
     * @return 'rutenummeret' til ruta
     */
    int getLink();
}
