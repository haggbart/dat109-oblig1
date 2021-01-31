package no.hvl.dat109.spiller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HjerneImplTest extends HjerneTest {


    @Override
    protected Hjerne createInstance() {
        return new HjerneImpl();
    }
}
