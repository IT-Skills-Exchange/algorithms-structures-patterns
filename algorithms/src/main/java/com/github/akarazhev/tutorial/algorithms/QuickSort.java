package com.github.akarazhev.tutorial.algorithms;

/**
 * Provides a sort method for quick sorting.
 */
final class QuickSort {
    /**
     * Sort an array.
     *
     * @param in an unsorted array.
     * @return a sorted array.
     */
    static int[] sort(final int[] in) {
        return sort(in, 0, in.length);
    }

    private static int[] sort(final int[] in, final int start, final int end) {
        if (end - start < 2) {
            return in;
        }

        final var pivot = partition(in, start, end);
        sort(in, start, pivot);
        sort(in, pivot + 1, end);
        return in;
    }

    private static int partition(int[] in, int start, int end) {
        // This is using the first element as the pivot
        int i = start;
        int j = end;
        final var pivot = in[start];
        while (i < j) {
            // NOTE: empty loop body
            while (i < j && in[--j] >= pivot) ;
            if (i < j) {
                in[i] = in[j];
            }
            // NOTE: empty loop body
            while (i < j && in[++i] <= pivot) ;
            if (i < j) {
                in[j] = in[i];
            }
        }

        in[j] = pivot;
        return j;
    }
}
