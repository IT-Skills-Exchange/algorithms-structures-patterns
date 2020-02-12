package com.github.akarazhev.tutorial.designpatterns.memento;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Provides the environment test for the snapshot and buffer.
 */
@DisplayName("Environment test")
final class EnvironmentTest {

    @Test
    @DisplayName("Save and restore")
    void saveRestore() {
        final var environment = new Environment();
        environment.setVersion(1000);
        assertEquals(1000, environment.getVersion());

        final var buffer = new Buffer();
        buffer.setSnapshot(environment.create());
        environment.setVersion(1001);
        assertEquals(1001, environment.getVersion());

        environment.restore(buffer.getSnapshot());
        assertEquals(1000, environment.getVersion());
    }
}
