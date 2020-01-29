package com.github.akarazhev.tutorial.designpatterns.composite;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Provides the сonfigs composite test.
 */
@DisplayName("User config test")
final class UserConfigTest {

    @Test
    @DisplayName("Get a user config value")
    void getUserConfigValue() {
        final UserConfig userConfig = new UserConfig("Name", 100);
        assertEquals(100, userConfig.getValue());
    }

    @Test
    @DisplayName("Get a user config name")
    void getUserConfigName() {
        final UserConfig userConfig = new UserConfig("Name", 100);
        assertEquals("Name", userConfig.getName());
    }
}
