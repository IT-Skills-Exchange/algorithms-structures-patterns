package com.github.akarazhev.tutorial.designpatterns.bridge;

import com.github.akarazhev.tutorial.designpatterns.builder.Property;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Provides the in-memory repository implementation to create, read, update and delete operations.
 */
public final class InMemRepository implements PropertyRepository {
    private final Transaction transaction;
    private final Map<String, Property> dataStorage = new HashMap<>();

    /**
     * Constructs an in-memory repository based on the transaction.
     *
     * @param transaction the transaction.
     */
    public InMemRepository(final Transaction transaction) {
        this.transaction = transaction;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Stream<Property> findByNames(final Stream<String> stream) {
        transaction.begin();
        try {
            final Collection<Property> properties = new LinkedList<>();
            stream.forEach(name -> {
                final var property = dataStorage.get(name);
                if (property != null) {
                    properties.add(property);
                }
            });

            return properties.stream().sorted(Comparator.comparing(Property::getName));
        } finally {
            transaction.end();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Stream<String> findNames() {
        transaction.begin();
        try {
            return dataStorage.keySet().stream().sorted();
        } finally {
            transaction.end();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Stream<Property> saveAndFlush(final Stream<Property> stream) {
        transaction.begin();
        try {
            stream.forEach(property -> dataStorage.put(property.getName(), property));
            return dataStorage.values().stream();
        } finally {
            transaction.end();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int delete(final Stream<String> stream) {
        transaction.begin();
        try {
            final var size = dataStorage.size();
            stream.forEach(dataStorage::remove);
            return size - dataStorage.size();
        } finally {
            transaction.end();
        }
    }
}
