package com.github.akarazhev.tutorial.designpatterns.composite;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Provides the сonfigs composite test.
 */
@DisplayName("Configs test")
final class ConfigsTest {

    @Test
    @DisplayName("Get a configs value")
    void getConfigsValue() {
        final var configs = new Configs();
        configs.add(new UserConfig("Name", 100));
        assertEquals(100, configs.getValue());
    }

    @Test
    @DisplayName("Get a configs name")
    void getConfigsName() {
        final var configs = new Configs();
        configs.add(new UserConfig("Name", 100));
        assertEquals("Name", configs.getName());
    }
}
