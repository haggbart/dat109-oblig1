package no.hvl.dat109.spiller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract class BrikkeTest {

    private Brikke brikke;

    protected abstract Brikke createInstance();

    @BeforeEach
    void setUp() {
        brikke = createInstance();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void setPosisjon() {
        assertEquals(1, brikke.getPosisjon());
        brikke.setPosisjon(4);
        assertEquals(4, brikke.getPosisjon());
    }

    @Test
    void getPosisjon() {

        assertEquals(1, brikke.getPosisjon());
        brikke.setPosisjon(8);
        assertEquals(8, brikke.getPosisjon());
    }
}
