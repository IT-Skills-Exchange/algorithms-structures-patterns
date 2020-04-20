package com.github.akarazhev.tutorial.datastructures.heap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Provides a test methods for a heap.
 */
@DisplayName("Heap test")
final class HeapTest {

    @Test
    @DisplayName("Tests a heap")
    void testHeap() {
        final var heap = new Heap(10);
        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);

        assertEquals("80, 75, 60, 68, 55, 40, 52, 67", heap.toString());
        assertEquals(80, heap.peek());

        heap.delete(0);
        assertEquals("75, 68, 60, 67, 55, 40, 52", heap.toString());
        assertEquals(75, heap.peek());

        heap.sort();
        assertEquals("40, 52, 55, 60, 67, 68, 75", heap.toString());
    }
}
