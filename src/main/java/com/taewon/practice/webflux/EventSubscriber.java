package com.taewon.practice.webflux;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class EventSubscriber {
    private static final Logger logger = LoggerFactory.getLogger(EventSubscriber.class);
    private final String name;

    public EventSubscriber(String name) {
        this.name = name;
    }

    public void subscribe(Flux<Event> publisher) {
        publisher.subscribe(
                event -> logger.info("Subscriber [{}] received: {}", name, event),
                error -> logger.error("Subscriber [{}] error: {}", name, error.getMessage()),
                () -> logger.info("Subscriber [{}] completed", name)
        );
    }
}