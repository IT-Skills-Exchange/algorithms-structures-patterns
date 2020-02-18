package com.github.akarazhev.tutorial.designpatterns.visitor;

/**
 * Provides the implementation for a perform visitor.
 */
final class PerformVisitor implements ServiceVisitor {
    /**
     * {@inheritDoc}
     */
    @Override
    public void visit(final Service service, final String name) {
        System.out.println("Visited: " + name);
    }
}
