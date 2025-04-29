package com.taewon.practice.webflux;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class WebFluxSampleApplication {
    private static final Logger logger = LoggerFactory.getLogger(WebFluxSampleApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WebFluxSampleApplication.class, args);
    }

    @Bean
    public CommandLineRunner runWebFluxSample() {
        return args -> {
            logger.info("Starting WebFlux Sample Application");

            // Create event generator (publisher)
            EventGenerator eventGenerator = new EventGenerator();

            // Create three subscribers
            EventSubscriber subscriber1 = new EventSubscriber("Subscriber-1");
            EventSubscriber subscriber2 = new EventSubscriber("Subscriber-2");
            EventSubscriber subscriber3 = new EventSubscriber("Subscriber-3");

            // Subscribe all subscribers to the event publisher
            subscriber1.subscribe(eventGenerator.getEventPublisher());
            subscriber2.subscribe(eventGenerator.getEventPublisher());
            subscriber3.subscribe(eventGenerator.getEventPublisher());

            logger.info("All subscribers are now listening for events");

            // Keep the application running
            Thread.sleep(Long.MAX_VALUE);
        };
    }
}