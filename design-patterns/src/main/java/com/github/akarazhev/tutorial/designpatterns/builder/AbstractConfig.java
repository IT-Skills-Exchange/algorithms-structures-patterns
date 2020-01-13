package com.github.akarazhev.tutorial.designpatterns.builder;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Implements the interface of <code>Configurable</code>
 * and provides additional functionality for getting properties.
 */
abstract class AbstractConfig implements Configurable {
    /**
     * Returns a property by paths.
     *
     * @param index  a current path.
     * @param paths  paths
     * @param source a current property stream.
     * @return a property.
     */
    Optional<Property> getProperty(final int index, final String[] paths, final Stream<Property> source) {
        if (index < paths.length) {
            final var current = source.
                    filter(property -> paths[index].equals(property.getName())).findFirst();
            if (current.isPresent()) {
                return index == paths.length - 1 ?
                        current : getProperty(index + 1, paths, current.get().getProperties());
            }
        }

        return Optional.empty();
    }
}
