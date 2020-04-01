package com.github.akarazhev.tutorial.algorithms;

/**
 * Provides a sort method for radix sorting.
 */
final class RadixSort {
    /**
     * Sort an array.
     *
     * @param in an unsorted array.
     * @return a sorted array.
     */
    static int[] sort(final int[] in) {
        for (var i = 0; i < 4; i++) {
            sort(in, i, 10);
        }

        return in;
    }

    private static void sort(final int[] in, final int position, final int radix) {
        final var length = in.length;
        final var counter = new int[radix];

        for (var value: in) {
            counter[getDigit(position, value, radix)]++;
        }
        // Adjust the count array
        for (var j = 1; j < radix; j++) {
            counter[j] += counter[j - 1];
        }

        final var buffer = new int[length];
        for (var i = length - 1; i >= 0; i--) {
            buffer[--counter[getDigit(position, in[i], radix)]] = in[i];
        }

        System.arraycopy(buffer, 0, in, 0, length);
    }

    private static int getDigit(final int position, final int value, final int radix) {
        return value / (int) Math.pow(radix, position) % radix;
    }
}
