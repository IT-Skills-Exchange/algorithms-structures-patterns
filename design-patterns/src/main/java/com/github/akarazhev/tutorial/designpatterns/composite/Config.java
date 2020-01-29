package com.github.akarazhev.tutorial.designpatterns.composite;

/**
 * Provides the basic config abstraction.
 */
public interface Config {
    /**
     * Returns a value of the config.
     *
     * @return a value.
     */
    int getValue();

    /**
     * Returns a name of the config.
     *
     * @return a config name.
     */
    String getName();
}
