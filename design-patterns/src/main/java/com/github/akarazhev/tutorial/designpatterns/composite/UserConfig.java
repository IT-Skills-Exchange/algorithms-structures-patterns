package com.github.akarazhev.tutorial.designpatterns.composite;

import com.github.akarazhev.tutorial.designpatterns.adapter.Config;

/**
 * The user config model that contains parameters.
 */
public final class UserConfig implements Config {
    private final int id;
    private final String name;

    /**
     * Constructs a user config based on the id and name.
     *
     * @param id   the name.
     * @param name the name.
     */
    public UserConfig(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return name;
    }
}
