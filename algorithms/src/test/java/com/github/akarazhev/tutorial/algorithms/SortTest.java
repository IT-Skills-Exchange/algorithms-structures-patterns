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

    @Test
    @DisplayName("Sorts an array with the counting sort algorithm")
    void countingSort() {
        final int[] in = { 2, 5, 9, 8, 2, 8, 7, 10, 4, 3 };
        final int[] out = CountingSort.sort(in);
        assertEquals(2, out[0]);
        assertEquals(2, out[1]);
        assertEquals(3, out[2]);
        assertEquals(4, out[3]);
        assertEquals(5, out[4]);
        assertEquals(7, out[5]);
        assertEquals(8, out[6]);
        assertEquals(8, out[7]);
        assertEquals(9, out[8]);
        assertEquals(10, out[9]);
    }

    @Test
    @DisplayName("Sorts an array with the radix sort algorithm")
    void radixSort() {
        final int[] in = { 4725, 4586, 1330, 8792, 1594, 5729 };
        final int[] out = RadixSort.sort(in);
        assertEquals(1330, out[0]);
        assertEquals(1594, out[1]);
        assertEquals(4586, out[2]);
        assertEquals(4725, out[3]);
        assertEquals(5729, out[4]);
        assertEquals(8792, out[5]);
    }

    @Test
    @DisplayName("Sorts an array with the bucket sort algorithm")
    void bucketSort() {
        final int[] in = { 54, 46, 83, 66, 95, 92, 43 };
        final int[] out = BucketSort.sort(in);
        assertEquals(43, out[0]);
        assertEquals(46, out[1]);
        assertEquals(54, out[2]);
        assertEquals(66, out[3]);
        assertEquals(83, out[4]);
        assertEquals(92, out[5]);
        assertEquals(95, out[6]);
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
