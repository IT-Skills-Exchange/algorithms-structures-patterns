package com.github.akarazhev.tutorial.algorithms;

/**
 * Provides a search method for linear search.
 */
final class LinearSearch {
    /**
     * Search a position in an array.
     *
     * @param in an input array.
     * @param value a value to find.
     * @return a found position.
     */
    static int search(final int[] in, final int value) {
        for (var i = 0; i < in.length; i++) {
            if (in[i] == value) {
                return i;
            }
        }

        return -1;
    }
}
