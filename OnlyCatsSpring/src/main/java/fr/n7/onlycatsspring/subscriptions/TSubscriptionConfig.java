package fr.n7.onlycatsspring.subscriptions;

import fr.n7.onlycatsspring.like.TLikeConfig;
import fr.n7.onlycatsspring.like.TLikeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TSubscriptionConfig {
    private static final Logger log = LoggerFactory.getLogger(TSubscriptionConfig.class);

    @Bean("subscription")
    CommandLineRunner initDatabase(TSubscriptionRepository repository) {

        return args -> {};
    }
}
