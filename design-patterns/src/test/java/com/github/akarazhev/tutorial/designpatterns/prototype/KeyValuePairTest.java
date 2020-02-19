package com.github.akarazhev.tutorial.designpatterns.prototype;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Simple key-value util object test.
 */
@DisplayName("KeyValuePair test")
final class KeyValuePairTest {

    @Test
    @DisplayName("Compare a KeyValuePair")
    void cloneKeyValuePair() {
        final var pair = new KeyValuePair<>("key", "value");
        // Check test results
        assertEquals("key", pair.getKey());
        assertEquals("value", pair.getValue());

        final var clonedPair = pair.clone();
        assertEquals("key", clonedPair.getKey());
        assertEquals("value", clonedPair.getValue());
    }
}
