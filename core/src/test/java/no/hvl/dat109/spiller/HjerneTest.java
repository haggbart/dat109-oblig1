package no.hvl.dat109.spiller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void kanKastePaNytt() {
        int oyne = 5;
        int posisjon = hjerne.hvorTil(10, oyne);
        assertFalse(hjerne.kanKastePaNytt(posisjon, oyne));
        oyne = 6;
        assertTrue(hjerne.kanKastePaNytt(posisjon, oyne));

    }

    @Test
    void treSeksPaRad() {
        int oyne = 6;
        int posisjon = hjerne.hvorTil(5, oyne);
        assertTrue(hjerne.kanKastePaNytt(posisjon, oyne));
        posisjon = hjerne.hvorTil(posisjon, oyne);
        assertTrue(hjerne.kanKastePaNytt(posisjon, 6));
        posisjon = hjerne.hvorTil(posisjon, oyne);

        assertFalse(hjerne.kanKastePaNytt(posisjon, oyne));
    }
}


