package com.github.akarazhev.tutorial.algorithms;

/**
 * Provides a sort method for insertion sorting.
 */
final class InsertionSort {
    /**
     * Sort an array.
     *
     * @param in an unsorted array.
     * @return a sorted array.
     */
    static int[] sort(final int[] in) {
        for (var firstUnsortedIndex = 1; firstUnsortedIndex < in.length; firstUnsortedIndex++) {
            int i;
            var newElement = in[firstUnsortedIndex];
            for (i = firstUnsortedIndex; i > 0 && in[i - 1] > newElement; i--) {
                in[i] = in[i - 1];
            }

            in[i] = newElement;
        }

        return in;
    }
}
