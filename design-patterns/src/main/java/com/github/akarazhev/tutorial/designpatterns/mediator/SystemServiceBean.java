package com.github.akarazhev.tutorial.designpatterns.mediator;

/**
 * Provides the implementation for a system service.
 */
final class SystemServiceBean extends Consumer implements SystemService {
    private int level;

    /**
     * Constructs a system service based on an event.
     *
     * @param event the event.
     */
    public SystemServiceBean(final Event event) {
        super(event);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void notify(final String message) {
        if ("setLevel".equals(message)) {
            level = 1000;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getLevel() {
        return level;
    }
}
