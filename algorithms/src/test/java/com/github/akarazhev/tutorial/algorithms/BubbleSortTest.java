package com.github.akarazhev.tutorial.algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Provides a test method for bubble sorting.
 */
@DisplayName("Bubble sort test")
final class BubbleSortTest {

    @Test
    @DisplayName("Sorts an array with the bubble sort algorithm")
    void sort() {
        final int[] in = { 20, 35, -15, 7, 55, 1, -22 };
        final int[] out = BubbleSort.sort(in);

        assertEquals(-22, out[0]);
        assertEquals(-15, out[1]);
        assertEquals(1, out[2]);
        assertEquals(7, out[3]);
        assertEquals(20, out[4]);
        assertEquals(35, out[5]);
        assertEquals(55, out[6]);
    }
}
