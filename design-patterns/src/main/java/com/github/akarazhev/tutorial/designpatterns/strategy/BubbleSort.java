package com.github.akarazhev.tutorial.designpatterns.strategy;

/**
 * Provides the implementation for bubble sort.
 */
final class BubbleSort implements Strategy {
    /**
     * {@inheritDoc}
     */
    @Override
    public int[] sort(int[] indices) {
        int index;
        for (var i = 0; i < indices.length; i++) {
            for (var j = 0; j < indices.length - 1 - i; j++) {
                if (indices[j] > indices[j + 1]) {
                    index = indices[j];
                    indices[j] = indices[j + 1];
                    indices[j + 1] = index;
                }
            }
        }

        return indices;
    }
}
