package com.github.akarazhev.tutorial.designpatterns.templatemethod;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Provides the implementation for a loader from a stream.
 */
final class StreamLoader extends DataLoader {
    private final Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    /**
     * {@inheritDoc}
     */
    @Override
    Collection<Integer> getData() {
        return stream.collect(Collectors.toList());
    }
}
