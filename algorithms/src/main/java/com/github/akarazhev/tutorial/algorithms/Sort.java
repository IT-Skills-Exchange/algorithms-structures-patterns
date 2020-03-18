package com.github.akarazhev.tutorial.algorithms;

/**
 * Provides service methods for sorting.
 */
final class Sort {
    /**
     * Swaps elements of an array.
     *
     * @param in an input array.
     * @param i  first index to swap.
     * @param j  second index to swap.
     */
    static void swap(final int[] in, final int i, final int j) {
        if (i == j) {
            return;
        }

        final var temp = in[i];
        in[i] = in[j];
        in[j] = temp;
    }
}
