package com.github.akarazhev.tutorial.designpatterns.proxy;

import com.github.akarazhev.tutorial.designpatterns.adapter.Config;

/**
 * The runtime config model that provides lazy-loading logic.
 */
final class RuntimeConfig implements Config {
    private Config config;

    /**
     * {@inheritDoc}
     */
    @Override
    public int getId() {
        initialize();
        return 1000 + config.getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        initialize();
        return "Runtime: " + config.getName();
    }

    /**
     * Performs a lazy initialization.
     */
    private void initialize() {
        if (config == null) {
            config = new ServiceConfig();
        }
    }
}
