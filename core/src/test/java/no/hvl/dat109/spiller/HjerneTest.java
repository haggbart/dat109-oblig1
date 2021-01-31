package no.hvl.dat109.spiller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class HjerneTest {

    private Hjerne hjerne;

    protected abstract Hjerne createInstance();

    @BeforeEach
    void setUp() {
        hjerne = createInstance();
    }

    @Test
    void hvorTil() {
        int posisjon = hjerne.hvorTil(1, 3);
        assertEquals(4, posisjon);

        posisjon = hjerne.hvorTil(4, 6);
        assertEquals(10, posisjon);
    }

    @Test
    void hvorTilSeksPaRad() {
        int posisjon = hjerne.hvorTil(10, 6);
        posisjon = hjerne.hvorTil(16, 6);
        assertEquals(22, posisjon);
        posisjon = hjerne.hvorTil(22, 6);
        assertEquals(1, posisjon);
    }

    @Test
    void kanIkkeFlytteOver100() {
        int posisjon = hjerne.hvorTil(98, 5);
        assertEquals(-1, posisjon);
    }
}


