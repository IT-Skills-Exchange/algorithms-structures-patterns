package com.github.akarazhev.tutorial.designpatterns.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * The Runtime singleton instance test.
 */
@DisplayName("Runtime test")
final class RuntimeTest {

    @Test
    @DisplayName("Get a runtime")
    void getRuntime() {
        final var runtime = Runtime.getInstance();
        // Check test results
        assertNotNull(runtime);
        assertEquals(runtime, Runtime.getInstance());
    }
}
