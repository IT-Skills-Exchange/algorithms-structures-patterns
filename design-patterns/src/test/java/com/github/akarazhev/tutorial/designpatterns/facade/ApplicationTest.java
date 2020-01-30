package com.github.akarazhev.tutorial.designpatterns.facade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Provides the application facade test.
 */
@DisplayName("Application test")
final class ApplicationTest {

    @Test
    @DisplayName("Start the application")
    void startApplication() throws Exception {
        final var application = new Application();
        application.start();
        assertTrue(application.isRunning());
        application.stop();
    }
}
