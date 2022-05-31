package fr.n7.onlycatsspring;

import fr.n7.onlycatsspring.files.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableConfigurationProperties(FileStorageProperties.class)
public class OnlyCatsSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlyCatsSpringApplication.class, args);
    }

}
