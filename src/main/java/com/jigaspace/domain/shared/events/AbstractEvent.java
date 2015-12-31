package com.jigaspace.domain.shared.events;

import static java.util.Objects.requireNonNull;

public class AbstractEvent<T> implements Event {
    private static final long serialVersionUID = 1L;

    private T payload;

    public AbstractEvent(final T payload) {
        this.payload = requireNonNull(payload);
    }

    public T getPayload() {
        return payload;
    }

    @Override
    public String toString() {
        return payload.toString();
    }
}
