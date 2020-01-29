package com.github.akarazhev.tutorial.designpatterns.composite;

/**
 * The user config model that contains parameters.
 */
final class UserConfig implements Config {
    private final String name;
    private final int value;

    /**
     * Constructs a user config based on the name and value.
     *
     * @param name  the name.
     * @param value the value.
     */
    public UserConfig(final String name, final int value) {
        this.name = name;
        this.value = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getValue() {
        return value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return name;
    }
}
