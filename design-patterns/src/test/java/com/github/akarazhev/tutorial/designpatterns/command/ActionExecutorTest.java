package com.github.akarazhev.tutorial.designpatterns.command;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Provides a test for the action executor.
 */
@DisplayName("Action executor test")
final class ActionExecutorTest {

    @Test
    @DisplayName("Execute action")
    void executeAction() {
        final var storage = new Storage();

        final var executor = new ActionExecutor();
        executor.register("push", storage::push);
        executor.register("pop", storage::pop);

        assertEquals(0, executor.execute("pop"));
        assertEquals(1, executor.execute("push"));
        assertEquals(1000, executor.execute("pop"));
    }
}
