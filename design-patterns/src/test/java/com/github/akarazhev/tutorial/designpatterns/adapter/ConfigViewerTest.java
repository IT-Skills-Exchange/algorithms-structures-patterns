package com.github.akarazhev.tutorial.designpatterns.adapter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Provides a test method to a view config.
 */
@DisplayName("Config viewer test")
final class ConfigViewerTest {

    @Test
    @DisplayName("Gets a property config log")
    void getLog() {
        assertEquals("1|Property", new ConfigViewer(new PropConfig()).getLog());
    }
}
