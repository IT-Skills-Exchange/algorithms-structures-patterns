package com.github.akarazhev.tutorial.designpatterns.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The index service instance test.
 */
@DisplayName("Index service test")
final class IndexServiceTest {

    @Test
    @DisplayName("Bubble sort")
    void bubbleSort() {
        var i = 0;
        final var service = new IndexService(new BubbleSort());
        for (final var index : service.sort(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1})) {
            assertEquals(++i, index);
        }
    }

    @Test
    @DisplayName("Insertion sort")
    void insertionSort() {
        var i = 0;
        final var service = new IndexService(new InsertionSort());
        for (final var index : service.sort(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1})) {
            assertEquals(++i, index);
        }
    }
}
