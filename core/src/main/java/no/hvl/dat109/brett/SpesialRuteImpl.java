package no.hvl.dat109.brett;

public class SpesialRuteImpl implements SpesialRute {

    private Type type;
    private int link;

    public SpesialRuteImpl(Type type, int link) {
        this.type = type;
        this.link = link;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public int getLink() {
        return link;
    }
}
