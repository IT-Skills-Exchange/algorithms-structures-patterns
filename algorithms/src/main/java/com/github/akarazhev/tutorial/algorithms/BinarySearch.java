package com.github.akarazhev.tutorial.algorithms;

/**
 * Provides a search method for binary search.
 */
final class BinarySearch {
    /**
     * Search a position in an array.
     *
     * @param in an input array.
     * @param value a value to find.
     * @return a found position.
     */
    static int iterative(final int[] in, final int value) {
        var start = 0;
        var end = in.length;
        while (start < end) {
            final int midpoint = (start + end) / 2;
            if (in[midpoint] == value) {
                return midpoint;
            } else if (in[midpoint] < value) {
                start = midpoint + 1;
            } else {
                end = midpoint;
            }
        }

        return -1;
    }

    /**
     * Search a position in an array.
     *
     * @param in an input array.
     * @param value a value to find.
     * @return a found position.
     */
    static int recursive(final int[] in, final int value) {
        return recursive(in, 0, in.length, value);
    }

    private static int recursive(final int[] in, final int start, final int end, final int value) {
        if (start >= end) {
            return -1;
        }

        final var midpoint = (start + end) / 2;
        if (in[midpoint] == value) {
            return midpoint;
        } else if (in[midpoint] < value) {
            return recursive(in, midpoint + 1, end, value);
        } else {
            return recursive(in, start, midpoint, value);
        }
    }
}
