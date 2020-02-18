package com.github.akarazhev.tutorial.designpatterns.visitor;

import java.util.List;

/**
 * Provides the implementation for a dispatcher.
 */
final class Application implements Service {
    private final List<Service> services;

    /**
     * Constructs an application.
     */
    public Application() {
        this.services = List.of(new DbService(), new WebService("Web service"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(final ServiceVisitor visitor) {
        for (final Service service : services) {
            service.accept(visitor);
        }

        visitor.visit(this, "Application");
    }
}
