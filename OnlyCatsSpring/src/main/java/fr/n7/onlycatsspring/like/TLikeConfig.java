package fr.n7.onlycatsspring.like;

import fr.n7.onlycatsspring.cat.TCatRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TLikeConfig {

    private static final Logger log = LoggerFactory.getLogger(TLikeConfig.class);

    @Bean("like")
    CommandLineRunner initDatabase(TLikeRepository repository) {

        return args -> {};
    }

}
