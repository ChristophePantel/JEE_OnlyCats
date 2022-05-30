package fr.n7.onlycatsspring.post;

import fr.n7.onlycatsspring.cat.TCatRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TPostConfig {

    private static final Logger log = LoggerFactory.getLogger(TPostConfig.class);

    @Bean("post")
    CommandLineRunner initDatabase(TPostRepository repository) {

        return args -> {};
    }

}
