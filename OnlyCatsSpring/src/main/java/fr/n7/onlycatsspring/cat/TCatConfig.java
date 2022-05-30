package fr.n7.onlycatsspring.cat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TCatConfig {

    private static final Logger log = LoggerFactory.getLogger(TCatConfig.class);

    @Bean("cat")
    CommandLineRunner initDatabase(TCatRepository repository) {

        return args -> {};
    }

}
