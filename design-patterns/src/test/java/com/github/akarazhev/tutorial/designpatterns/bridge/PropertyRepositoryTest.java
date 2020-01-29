package com.github.akarazhev.tutorial.designpatterns.bridge;

import com.github.akarazhev.tutorial.designpatterns.builder.Property;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Provides the property bridge test.
 */
@DisplayName("Property repository test")
final class PropertyRepositoryTest {
    private final PropertyRepository repository = new InMemRepository(new LockTransaction());

    @Test
    @DisplayName("Save and flush property")
    void saveAndFlushProperty() {
        final var property = new Property.Builder("Property", "Value").build();
        final var stream = repository.saveAndFlush(Stream.of(property));
        final var foundProperty = stream.findFirst();
        // Check test results
        assertTrue(foundProperty.isPresent());
        assertEquals("Property", foundProperty.get().getName());
        assertEquals("Value", foundProperty.get().getValue());
    }
}
