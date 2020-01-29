package com.github.akarazhev.tutorial.designpatterns.adapter;

/**
 * Provides basic methods for a config viewer.
 */
final class ConfigViewer {
    private final Config config;

    /**
     * Constructs a config viewer based on a config.
     *
     * @param config a config.
     */
    public ConfigViewer(final Config config) {
        this.config = config;
    }

    /**
     * View the config.
     */
    public String getLog() {
        return config.getId() + "|" + config.getName();
    }
}
