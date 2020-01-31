package com.github.akarazhev.tutorial.designpatterns.proxy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Provides the runtime config proxy test.
 */
@DisplayName("Runtime config test")
final class RuntimeConfigTest {

    @Test
    @DisplayName("Get a runtime config id")
    void getRuntimeConfigId() {
        final var runtimeConfig = new RuntimeConfig();
        assertEquals(1100, runtimeConfig.getId());
    }

    @Test
    @DisplayName("Get a runtime config name")
    void getRuntimeConfigName() {
        final var runtimeConfig = new RuntimeConfig();
        assertEquals("Runtime: Service Name", runtimeConfig.getName());
    }
}
