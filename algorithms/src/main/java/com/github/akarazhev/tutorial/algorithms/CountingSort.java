package com.github.akarazhev.tutorial.algorithms;

/**
 * Provides a sort method for counting sorting.
 */
final class CountingSort {
    /**
     * Sort an array.
     *
     * @param in an unsorted array.
     * @return a sorted array.
     */
    static int[] sort(final int[] in) {
        return sort(in, 1, 10);
    }

    private static int[] sort(final int[] in, final int min, final int max) {
        final var count = new int[(max - min) + 1];
        for (var i = 0; i < in.length; i++) {
            count[in[i] - min]++;
        }

        var j = 0;
        for (var i = min; i <= max; i++) {
            while (count[i - min] > 0) {
                in[j++] = i;
                count[i - min]--;
            }
        }

        return in;
    }
}
