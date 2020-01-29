package com.github.akarazhev.tutorial.designpatterns.adapter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Provides the property adapter test.
 */
@DisplayName("Property config test")
final class PropConfigTest {

    @Test
    @DisplayName("Create a property config")
    void createPropConfig() {
        final var propConfig = new PropConfig();
        assertEquals(1, propConfig.getId());
        assertEquals("Property", propConfig.getName());
    }
}
