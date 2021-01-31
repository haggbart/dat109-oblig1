package no.hvl.dat109.brett;

import lombok.Getter;

@Getter
public class SpesialRuteImpl implements SpesialRute {

    private final Type type;
    private final int link;

    public SpesialRuteImpl(Type type, int link) {
        this.type = type;
        this.link = link;
    }
}
