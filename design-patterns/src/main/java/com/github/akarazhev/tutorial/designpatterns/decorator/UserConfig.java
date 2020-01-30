package com.github.akarazhev.tutorial.designpatterns.decorator;

import com.github.akarazhev.tutorial.designpatterns.adapter.Config;

import java.util.UUID;

/**
 * Provides functionality for the user config that extends the system config.
 */
final class UserConfig extends SystemConfig {
    private final UUID uuid;

    /**
     * Constructs a use config based on the uuid and config.
     *
     * @param uuid a uuid.
     * @param config a config.
     */
    UserConfig(final UUID uuid, final Config config) {
        super(config);
        this.uuid = uuid;
    }

    /**
     * Returns an uuid of the config.
     *
     * @return a uuid.
     */
    public UUID getUuid() {
        return uuid;
    }
}
