package com.github.akarazhev.tutorial.designpatterns.templatemethod;

import java.util.Collection;
import java.util.List;

/**
 * Provides the implementation for a loader from a collection.
 */
final class CollectionLoader extends DataLoader {
    private final Collection<Integer> collection = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    /**
     * {@inheritDoc}
     */
    @Override
    Collection<Integer> getData() {
        return collection;
    }
}
