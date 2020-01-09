package com.github.akarazhev.tutorial.designpatterns.builder;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Provides functionality for getting attributes and properties.
 */
interface Configurable {
    /**
     * Returns attributes which belong to configurations.
     *
     * @return attributes as a map.
     */
    Optional<Map<String, String>> getAttributes();

    /**
     * Returns attribute keys which belong to configurations.
     *
     * @return attribute keys as a stream.
     */
    Stream<String> getAttributeKeys();

    /**
     * Returns an attribute value by the key.
     *
     * @param key attribute key.
     * @return a value by the key.
     */
    Optional<String> getAttribute(final String key);

    /**
     * Returns properties which belong to configurations.
     *
     * @return properties as a stream.
     */
    Stream<Property> getProperties();

    /**
     * Returns a property by paths.
     *
     * @param paths property paths.
     * @return a property.
     */
    Optional<Property> getProperty(final String... paths);

    /**
     * Provides methods for getting attributes and properties from json objects.
     */
    class ConfigBuilder {
        final Map<String, String> attributes = new HashMap<>();
        final Collection<Property> properties = new LinkedList<>();

        /**
         * Sets properties which belong to configurations.
         *
         * @param paths      path to properties.
         * @param properties properties to set.
         */
        void setProperties(final String[] paths, final Collection<Property> properties) {
            final var propertyPaths = Validator.of(paths).get();
            if (propertyPaths.length > 0) {
                setProperties(this.properties, 0, paths, properties);
            } else {
                this.properties.addAll(Validator.of(properties).get());
            }
        }

        private void setProperties(final Collection<Property> target, final int index, final String[] paths,
                                   final Collection<Property> source) {
            if (index < paths.length) {
                final var nextIndex = index + 1;
                final var current = target.stream().
                        filter(property -> paths[index].equals(property.getName())).findFirst();
                if (current.isPresent()) {
                    setProperties(current.get().getProps(), nextIndex, paths, source);
                } else {
                    final var newProperty = new Property.Builder(paths[index], "").build();
                    target.add(newProperty);
                    setProperties(newProperty.getProps(), nextIndex, paths, source);
                }
            } else {
                target.addAll(source);
            }
        }
    }
}
