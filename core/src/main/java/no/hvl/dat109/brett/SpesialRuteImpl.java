package no.hvl.dat109.brett;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter @Setter
@Component @Scope("prototype")
public class SpesialRuteImpl implements SpesialRute {

    private Type type;
    private int link;
}
