package com.github.akarazhev.tutorial.designpatterns.state;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The context instance test.
 */
@DisplayName("Context test")
final class ContextTest {

    @Test
    @DisplayName("Execute")
    void execute() {
        final var context = new Context();
        assertEquals("Offline", context.getState());
        context.execute("start");
        assertEquals("Online", context.getState());
        context.execute("pause");
        assertEquals("Paused", context.getState());
        context.execute("stop");
        assertEquals("Offline", context.getState());
    }
}
