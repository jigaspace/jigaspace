package com.jigaspace.domain.shared.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventPublisher {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventPublisher.class);

    public static void publish(Event event) {
        LOGGER.debug("Publishing event {}", event);
    }
}
