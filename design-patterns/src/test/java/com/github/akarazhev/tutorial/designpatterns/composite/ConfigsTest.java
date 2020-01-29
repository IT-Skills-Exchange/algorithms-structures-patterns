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
    @DisplayName("Get a configs id")
    void getConfigsId() {
        final var configs = new Configs();
        configs.add(new UserConfig(100, "Name"));
        assertEquals(100, configs.getId());
    }

    @Test
    @DisplayName("Get a configs name")
    void getConfigsName() {
        final var configs = new Configs();
        configs.add(new UserConfig(100, "Name"));
        assertEquals("Name", configs.getName());
    }
}
