package com.github.akarazhev.tutorial.algorithms;

/**
 * Provides a sort method for shell sorting.
 */
final class ShellSort {
    /**
     * Sort an array.
     *
     * @param in an unsorted array.
     * @return a sorted array.
     */
    static int[] sort(final int[] in) {
        for (var gap = in.length / 2; gap > 0; gap /= 2) {
            for (var i = gap; i < in.length; i++) {
                var j = i;
                var newElement = in[i];
                while (j >= gap && in[j - gap] > newElement) {
                    in[j] = in[j - gap];
                    j -= gap;
                }

                in[j] = newElement;
            }
        }
        
        return in;
    }
}
