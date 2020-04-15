package com.github.akarazhev.tutorial.algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Provides a test method for search.
 */
@DisplayName("Search test")
final class SearchTest {

    @Test
    @DisplayName("Searches an array with the linear search algorithm")
    void linearSort() {
        final int[] in = { 20, 35, -15, 7, 55, 1, -22 };
        assertEquals(2, LinearSearch.search(in, -15));
        assertEquals(5, LinearSearch.search(in, 1));
        assertEquals(-1, LinearSearch.search(in, 8888));
        assertEquals(6, LinearSearch.search(in, -22));
    }

    @Test
    @DisplayName("Searches an array with the binary search algorithm")
    void binarySort() {
        final int[] in = { -22, -15, 1, 7, 20, 35, 55 };
        assertEquals(1, BinarySearch.iterative(in, -15));
        assertEquals(2, BinarySearch.iterative(in, 1));
        assertEquals(-1, BinarySearch.iterative(in, 8888));
        assertEquals(0, BinarySearch.iterative(in, -22));

        assertEquals(1, BinarySearch.recursive(in, -15));
        assertEquals(2, BinarySearch.recursive(in, 1));
        assertEquals(-1, BinarySearch.recursive(in, 8888));
        assertEquals(0, BinarySearch.recursive(in, -22));
    }
}
