package com.github.akarazhev.tutorial.designpatterns.adapter;

/**
 * Provides the config for getting parameters.
 */
public interface Config {
    /**
     * Returns an id of the config.
     *
     * @return a config id.
     */
    int getId();

    /**
     * Returns a name of the config.
     *
     * @return a config name.
     */
    String getName();
}
