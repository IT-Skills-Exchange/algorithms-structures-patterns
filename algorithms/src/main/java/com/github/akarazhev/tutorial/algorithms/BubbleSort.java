package com.github.akarazhev.tutorial.algorithms;

/**
 * Provides a sort method for bubble sorting.
 */
final class BubbleSort {
    /**
     * Sort an array.
     *
     * @param in an unsorted array.
     * @return a sorted array.
     */
    static int[] sort(final int[] in) {
        for (var lastUnsortedIndex = in.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for (var i = 0; i < lastUnsortedIndex; i++) {
                if (in[i] > in[i + 1]) {
                    Sort.swap(in, i, i + 1);
                }
            }
        }

        return in;
    }
}
