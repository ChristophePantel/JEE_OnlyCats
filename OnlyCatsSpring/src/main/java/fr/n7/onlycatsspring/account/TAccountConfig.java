package fr.n7.onlycatsspring.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TAccountConfig {

    private static final Logger log = LoggerFactory.getLogger(TAccountConfig.class);

    @Bean("account")
    CommandLineRunner initDatabase(TAccountRepository repository) {

        return args -> {};
    }

}
