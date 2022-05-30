package fr.n7.onlycatsspring.comment;

import fr.n7.onlycatsspring.cat.TCatRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TCommentConfig {

    private static final Logger log = LoggerFactory.getLogger(TCommentConfig.class);

    @Bean("comment")
    CommandLineRunner initDatabase(TCommentRepository repository) {

        return args -> {};
    }

}
