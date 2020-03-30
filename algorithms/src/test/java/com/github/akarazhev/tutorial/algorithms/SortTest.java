package com.github.akarazhev.tutorial.algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Provides a test method for sorting.
 */
@DisplayName("Sort test")
final class SortTest {

    @Test
    @DisplayName("Sorts an array with the bubble sort algorithm")
    void bubbleSort() {
        final int[] in = {20, 35, -15, 7, 55, 1, -22};
        assertArray(BubbleSort.sort(in));
    }

    @Test
    @DisplayName("Sorts an array with the selection sort algorithm")
    void selectionSort() {
        final int[] in = {20, 35, -15, 7, 55, 1, -22};
        assertArray(SelectionSort.sort(in));
    }

    @Test
    @DisplayName("Sorts an array with the insertion sort algorithm")
    void insertionSort() {
        final int[] in = {20, 35, -15, 7, 55, 1, -22};
        assertArray(InsertionSort.sort(in));
    }

    @Test
    @DisplayName("Sorts an array with the shell sort algorithm")
    void shellSort() {
        final int[] in = {20, 35, -15, 7, 55, 1, -22};
        assertArray(ShellSort.sort(in));
    }

    @Test
    @DisplayName("Sorts an array with the merge sort algorithm")
    void mergeSort() {
        final int[] in = {20, 35, -15, 7, 55, 1, -22};
        assertArray(MergeSort.sort(in));
    }

    @Test
    @DisplayName("Sorts an array with the quick sort algorithm")
    void quickSort() {
        final int[] in = {20, 35, -15, 7, 55, 1, -22};
        assertArray(QuickSort.sort(in));
    }

    private void assertArray(final int[] out) {
        assertEquals(-22, out[0]);
        assertEquals(-15, out[1]);
        assertEquals(1, out[2]);
        assertEquals(7, out[3]);
        assertEquals(20, out[4]);
        assertEquals(35, out[5]);
        assertEquals(55, out[6]);
    }
}
