package com.github.akarazhev.tutorial.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Provides a sort method for bucket sorting.
 */
final class BucketSort {
    /**
     * Sort an array.
     *
     * @param in an unsorted array.
     * @return a sorted array.
     */
    static int[] sort(final int[] in) {
        final List<Integer>[] buckets = new List[10];
        for (var i = 0; i < buckets.length; i++) {
            // using linked lists for the buckets
            // buckets[i] = new LinkedList<Integer>();

            // using arraylists as the buckets
            buckets[i] = new ArrayList<>();
        }

        for (var item : in) {
            buckets[hash(item)].add(item);
        }

        for (final var bucket : buckets) {
            Collections.sort(bucket);
        }

        var j = 0;
        for (final var bucket : buckets) {
            for (final var value : bucket) {
                in[j++] = value;
            }
        }

        return in;
    }

    private static int hash(final int value) {
        return value / 10;
    }
}
