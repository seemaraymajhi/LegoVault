package be.kdg.legoproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsoleApp {

    private static final Logger log =
            LoggerFactory.getLogger(ConsoleApp.class);

    public static void main(String[] args) {
        // Starts Spring, which creates and connects the View, services,
        // repositories and DataFactory based on their annotations.
        log.info("Starting LegoVault");
        SpringApplication.run(ConsoleApp.class, args);
    }
}
