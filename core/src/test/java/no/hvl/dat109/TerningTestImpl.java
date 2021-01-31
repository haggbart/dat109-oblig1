package no.hvl.dat109;

import org.springframework.context.ApplicationEventPublisher;

import static org.mockito.Mockito.mock;

public class TerningTestImpl extends TerningTest {


    private final ApplicationEventPublisher publisher = mock(ApplicationEventPublisher.class);

    @Override
    protected Terning createInstance() {
        return new TerningImpl(publisher);
    }
}
