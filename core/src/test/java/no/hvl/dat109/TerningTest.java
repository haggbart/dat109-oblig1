package no.hvl.dat109;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

abstract class TerningTest {

    private Terning terning;

    protected abstract Terning createInstance();

    @BeforeEach
    void setUp() {
        terning = createInstance();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void trill() {
        for (int i = 0; i < 10; i++) {
            int verdi = terning.trill();
            assertTrue(verdi >= 1 && verdi <= 6);
        }
    }
}
