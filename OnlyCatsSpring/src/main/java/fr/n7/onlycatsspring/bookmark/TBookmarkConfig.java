package fr.n7.onlycatsspring.bookmark;

import fr.n7.onlycatsspring.account.TAccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TBookmarkConfig {
    private static final Logger log = LoggerFactory.getLogger(fr.n7.onlycatsspring.bookmark.TBookmarkConfig.class);

    @Bean("bookmark")
    CommandLineRunner initDatabase(TBookmarkRepository repository) {

        return args -> {};
    }
}