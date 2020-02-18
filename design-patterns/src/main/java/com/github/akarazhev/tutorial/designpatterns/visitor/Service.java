package com.github.akarazhev.tutorial.designpatterns.visitor;

/**
 * The specification of the service.
 */
public interface Service {
    /**
     * Accepts a visitor implementation.
     *
     * @param visitor a visitor.
     */
    void accept(final ServiceVisitor visitor);
}
