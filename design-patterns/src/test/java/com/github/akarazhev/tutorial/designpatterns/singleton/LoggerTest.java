package com.github.akarazhev.tutorial.designpatterns.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * The logger singleton instance test.
 */
@DisplayName("Logger test")
final class LoggerTest {

    @Test
    @DisplayName("Get a logger")
    void getLogger() {
        final var logger = Logger.INSTANCE;
        // Check test results
        assertNotNull(logger);
        assertEquals(0, logger.getLevel());
        logger.setLevel(1);
        assertEquals(logger, Logger.INSTANCE);
        assertEquals(1, Logger.INSTANCE.getLevel());
    }
}
