package com.github.akarazhev.tutorial.designpatterns.interpreter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static com.github.akarazhev.tutorial.designpatterns.interpreter.Interpreter.parse;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Provides the interpreter logic test.
 */
@DisplayName("Interpreter test")
final class InterpreterTest {

    @Test
    @DisplayName("Parse and interpret")
    void parseAndInterpret() {
        final var expression = parse("w x z - +");
        assertEquals(-27, expression.interpret(Map.of("w", 5, "x", 10, "z", 42)));
    }
}
