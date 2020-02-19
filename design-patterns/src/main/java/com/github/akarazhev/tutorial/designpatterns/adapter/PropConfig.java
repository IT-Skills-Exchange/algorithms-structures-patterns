package com.github.akarazhev.tutorial.designpatterns.adapter;

import com.github.akarazhev.tutorial.designpatterns.builder.Property;

/**
 * The property adapter that contains parameters.
 */
final class PropConfig implements Config {
    private final Property property = new Property.Builder("Property", 1).build();

    /**
     * {@inheritDoc}
     */
    @Override
    public int getId() {
        return (int) property.asLong();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        final var name = property.getName();
        return property.getDescription().isPresent() ? name + "." + property.getDescription().get() : name;
    }
}
