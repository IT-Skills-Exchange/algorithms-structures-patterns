package com.github.akarazhev.tutorial.designpatterns.decorator;

import com.github.akarazhev.tutorial.designpatterns.adapter.Config;

/**
 * Provides functionality for the application config that extends the system config.
 */
final class AppConfig extends SystemConfig {
    private final int version;

    /**
     * Constructs an application config based on the version and config.
     *
     * @param version a version.
     * @param config a config.
     */
    AppConfig(final int version, final Config config) {
        super(config);
        this.version = version;
    }

    /**
     * Returns a version of the config.
     *
     * @return a config version.
     */
    public int getVersion() {
        return version;
    }
}
