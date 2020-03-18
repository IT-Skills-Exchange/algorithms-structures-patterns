package com.github.akarazhev.tutorial.algorithms;

/**
 * Provides a sort method for selection sorting.
 */
final class SelectionSort {
    /**
     * Sort an array.
     *
     * @param in an unsorted array.
     * @return a sorted array.
     */
    static int[] sort(final int[] in) {
        for (var lastUnsortedIndex = in.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            var largest = 0;
            for (var i = 1; i <= lastUnsortedIndex; i++) {
                if (in[i] > in[largest]) {
                    largest = i;
                }
            }

            Sort.swap(in, largest, lastUnsortedIndex);
        }

        return in;
    }
}
