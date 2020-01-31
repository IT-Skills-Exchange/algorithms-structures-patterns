package com.github.akarazhev.tutorial.designpatterns.composite;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Provides the user сonfig composite test.
 */
@DisplayName("User config test")
final class UserConfigTest {

    @Test
    @DisplayName("Get a user config id")
    void getUserConfigId() {
        final var userConfig = new UserConfig(100, "Name");
        assertEquals(100, userConfig.getId());
    }

    @Test
    @DisplayName("Get a user config name")
    void getUserConfigName() {
        final var userConfig = new UserConfig(100, "Name");
        assertEquals("Name", userConfig.getName());
    }
}
