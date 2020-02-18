package com.github.akarazhev.tutorial.designpatterns.visitor;

/**
 * The specification of the service visitor.
 */
public interface ServiceVisitor {
    /**
     * Visits an application logic with a service and argument.
     *
     * @param service a service implementation.
     * @param name    a name argument.
     */
    void visit(final Service service, final String name);
}
