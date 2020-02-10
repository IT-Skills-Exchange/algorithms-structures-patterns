package com.github.akarazhev.tutorial.designpatterns.mediator;

import java.util.HashSet;
import java.util.Set;

/**
 * Provides the implementation for an event exchanger.
 */
final class Exchanger implements Event {
    private final Set<Consumer> consumers = new HashSet<>();

    /**
     * Registers a consumer.
     *
     * @param consumer a consumer.
     */
    public void register(final Consumer consumer) {
        consumers.add(consumer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void send(final String message, final Consumer eventConsumer) {
        consumers.stream().
                filter(consumer -> consumer.equals(eventConsumer)).
                forEach(consumer -> consumer.notify(message));
    }
}
