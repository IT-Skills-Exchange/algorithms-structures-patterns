package com.github.akarazhev.tutorial.algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Provides a test method for factorials.
 */
@DisplayName("Factorial test")
final class FactorialTest {

    @Test
    @DisplayName("Calculates a factorial value recursively")
    void recursive() {
        assertEquals(6, Factorial.recursive(3));
    }

    @Test
    @DisplayName("Calculates a factorial value iteratively")
    void iterative() {
        assertEquals(6, Factorial.iterative(3));
    }
}
