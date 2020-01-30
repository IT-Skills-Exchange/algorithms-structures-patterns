package com.github.akarazhev.tutorial.designpatterns.bridge;

import com.github.akarazhev.tutorial.designpatterns.builder.Property;

import java.util.stream.Stream;

/**
 * Provides repository methods to create, read, update and delete operations.
 */
public interface PropertyRepository {
    /**
     * Returns property models for property names.
     *
     * @param stream a stream of names.
     * @return a stream of properties models.
     */
    Stream<Property> findByNames(final Stream<String> stream);

    /**
     * Returns all property names.
     *
     * @return a stream of property names.
     */
    Stream<String> findNames();

    /**
     * Saves and flushes property models.
     *
     * @param stream a stream of property models.
     * @return a stream of updated property models.
     */
    Stream<Property> saveAndFlush(final Stream<Property> stream);

    /**
     * Deletes property models.
     *
     * @param stream a stream of names.
     * @return a number of deleted models.
     */
    int delete(final Stream<String> stream);
}
