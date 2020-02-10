package com.github.akarazhev.tutorial.designpatterns.mediator;

/**
 * Provides the implementation for a user service.
 */
class UserServiceBean extends Consumer implements UserService {
    private String name;

    /**
     * Constructs a user service based on an event.
     *
     * @param event the event.
     */
    public UserServiceBean(final Event event) {
        super(event);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void notify(final String message) {
        if ("setName".equals(message)) {
            name = "My Name";
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return name;
    }
}
