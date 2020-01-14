package com.github.akarazhev.tutorial.designpatterns.abstractfactory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Provides a factory method to create an appropriate platform test.
 */
@DisplayName("Platforms test")
final class PlatformsTest {

    @Test
    @DisplayName("Create new embedded platform")
    void createNewEmbeddedPlatform() throws Exception {
        final var platform = Platforms.newPlatform(Platforms.Type.EMBEDDED);
        assertNotNull(platform.newDbServer());
    }

    @Test
    @DisplayName("Create new stand alone platform")
    void createNewStandAlonePlatform() throws Exception {
        final var platform = Platforms.newPlatform(Platforms.Type.STANDALONE);
        assertNotNull(platform.newDbServer());
    }
}
