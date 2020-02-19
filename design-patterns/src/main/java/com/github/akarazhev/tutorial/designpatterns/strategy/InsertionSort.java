package com.github.akarazhev.tutorial.designpatterns.strategy;

/**
 * Provides the implementation for insertion sort.
 */
final class InsertionSort implements Strategy {
    /**
     * {@inheritDoc}
     */
    @Override
    public int[] sort(int[] indices) {
        int j, index;
        for (var i = 1; i < indices.length; i++) {
            index = indices[i];
            for (j = i; j > 0 && indices[j - 1] > index; j--) {
                indices[j] = indices[j - 1];
            }

            indices[j] = index;
        }

        return indices;
    }
}
