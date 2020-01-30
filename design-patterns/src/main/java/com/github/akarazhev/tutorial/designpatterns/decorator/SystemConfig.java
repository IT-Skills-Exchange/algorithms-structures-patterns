package com.github.akarazhev.tutorial.designpatterns.decorator;

import com.github.akarazhev.tutorial.designpatterns.adapter.Config;

/**
 * Provides functionality for the system config model that implements based methods.
 */
class SystemConfig implements Config {
    private final Config config;

    /**
     * Constructs a system config based on the config.
     *
     * @param config a config.
     */
    SystemConfig(final Config config) {
        this.config = config;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getId() {
        return config.getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return config.getName();
    }
}
