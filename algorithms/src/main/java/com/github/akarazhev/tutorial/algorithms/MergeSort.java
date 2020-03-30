package com.github.akarazhev.tutorial.algorithms;

/**
 * Provides a sort method for merge sort.
 */
final class MergeSort {
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

        final var mid = (start + end) / 2;
        sort(in, start, mid);
        sort(in, mid, end);
        merge(in, start, mid, end);
        return in;
    }

    private static void merge(final int[] in, final int start, final int mid, final int end) {
        if (in[mid - 1] <= in[mid]) {
            return;
        }

        var i = start;
        var j = mid;
        var tempIndex = 0;

        final var temp = new int[end - start];
        while (i < mid && j < end) {
            temp[tempIndex++] = in[i] <= in[j] ? in[i++] : in[j++];
        }

        System.arraycopy(in, i, in, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, in, start, tempIndex);
    }
}
