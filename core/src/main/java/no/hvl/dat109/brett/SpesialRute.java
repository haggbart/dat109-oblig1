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

    void setType(Type type);

    /**
     * Link er assosiert med ruta som er i enden av stigen/slangen.
     * @return 'rutenummeret' til ruta
     */
    int getLink();

    void setLink(int rute);
}
