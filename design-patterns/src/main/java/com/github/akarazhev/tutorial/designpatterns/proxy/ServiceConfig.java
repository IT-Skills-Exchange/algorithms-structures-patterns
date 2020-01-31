package com.github.akarazhev.tutorial.designpatterns.proxy;

import com.github.akarazhev.tutorial.designpatterns.adapter.Config;

/**
 * The service config model that contains logic.
 */
final class ServiceConfig implements Config {
    /**
     * {@inheritDoc}
     */
    @Override
    public int getId() {
        return 100;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "Service Name";
    }
}
