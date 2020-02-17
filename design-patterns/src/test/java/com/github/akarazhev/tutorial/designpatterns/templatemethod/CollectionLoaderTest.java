package com.github.akarazhev.tutorial.designpatterns.templatemethod;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The collection loader instance test.
 */
@DisplayName("Collection loader test")
final class CollectionLoaderTest {

    @Test
    @DisplayName("Get encoded")
    void getEncoded() {
        final var dataLoader = new CollectionLoader();
        assertEquals("1:2:3:4:5:6:7:8:9:10", dataLoader.getEncoded());
    }
}
