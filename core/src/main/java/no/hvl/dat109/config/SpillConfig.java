package no.hvl.dat109.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "no.hvl.dat109")
@PropertySource("classpath:config/spill.properties")
public class SpillConfig {

    // == fields ==
    @Value("${spill.antallSpillere:4}")
    private int antallSpillere;

    // == bean methods ==
    @Bean
    @AntallSpillere
    public int antallSpillere() {
        return antallSpillere;
    }
}
