package com.taewon.practice.webflux.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicLong;

public class EventGenerator {
    private static final Logger logger = LoggerFactory.getLogger(EventGenerator.class);
    private final AtomicLong eventId = new AtomicLong(0);
    private final Sinks.Many<Event> eventSink = Sinks.many().multicast().onBackpressureBuffer();

    public EventGenerator() {
        // Start a separate thread to generate events every 20 seconds
        Flux.interval(Duration.ZERO, Duration.ofSeconds(3))
                .subscribe(tick -> {
                    Event event = new Event(eventId.incrementAndGet(), "Periodic event at " + tick);
                    logger.info("Generated: {}", event);
                    eventSink.tryEmitNext(event);
                });
    }

    public Flux<Event> getEventPublisher() {
        return eventSink.asFlux();
    }
}