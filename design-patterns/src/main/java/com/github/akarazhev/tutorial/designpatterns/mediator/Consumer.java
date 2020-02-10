package com.github.akarazhev.tutorial.designpatterns.mediator;

/**
 * Provides the implementation for the event consumer.
 */
abstract class Consumer {
    private final Event event;

    /**
     * Constructs a consumer based on an event.
     *
     * @param event the event.
     */
    public Consumer(final Event event) {
        this.event = event;
    }

    /**
     * Sends a message to a service.
     *
     * @param message a message.
     */
    public void send(final String message) {
        event.send(message, this);
    }

    /**
     * Notifies a service.
     *
     * @param message a message.
     */
    public abstract void notify(final String message);
}
