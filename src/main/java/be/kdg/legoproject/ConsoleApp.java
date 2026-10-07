package be.kdg.legoproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsoleApp {

    public static void main(String[] args) {
        // Starts Spring, which creates and connects the View, services,
        // repositories and DataFactory based on their annotations.
        SpringApplication.run(ConsoleApp.class, args);
    }
}
