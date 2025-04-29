package com.taewon.practice.webflux;

import java.time.LocalDateTime;

public class Event {
    private final Long id;
    private final LocalDateTime timestamp;
    private final String message;

    public Event(Long id, String message) {
        this.id = id;
        this.timestamp = LocalDateTime.now();
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", message='" + message + '\'' +
                '}';
    }
}