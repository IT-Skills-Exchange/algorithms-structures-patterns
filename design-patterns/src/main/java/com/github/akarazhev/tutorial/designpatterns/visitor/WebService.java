package com.github.akarazhev.tutorial.designpatterns.visitor;

/**
 * Provides the implementation for a web service.
 */
final class WebService implements Service {
    private final String name;

    /**
     * Constructs a web service.
     *
     * @param name a name.
     */
    public WebService(final String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(final ServiceVisitor visitor) {
        visitor.visit(this, name);
    }
}
