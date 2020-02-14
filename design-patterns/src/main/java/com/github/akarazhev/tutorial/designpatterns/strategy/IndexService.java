package com.github.akarazhev.tutorial.designpatterns.strategy;

/**
 * Provides the implementation for a index service.
 */
final class IndexService {
    private Strategy strategy;

    /**
     * Constructs an index service based on a strategy.
     *
     * @param strategy a strategy.
     */
    public IndexService(final Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Sets a strategy.
     *
     * @param strategy a strategy.
     */
    public void setStrategy(final Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Sorts source indices by a certain algorithm.
     *
     * @param indices source indices.
     * @return sorted indices.
     */
    public int[] sort(int[] indices) {
        return strategy.sort(indices);
    }
}
