package com.github.akarazhev.tutorial.designpatterns.composite;

import com.github.akarazhev.tutorial.designpatterns.adapter.Config;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * The configs model that provides the application logic that allows to work with the collection of configs as a config.
 */
public final class Configs implements Config, Iterator<Config> {
    private int position = 0;
    private final List<Config> configs = new LinkedList<>();

    /**
     * Adds a new config.
     *
     * @param config a config.
     */
    public void add(final Config config) {
        configs.add(config);
    }

    /**
     * Removes a config.
     *
     * @param config a config.
     */
    public void remove(final Config config) {
        configs.remove(config);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getId() {
        var value = 0;
        for (final var config : configs) {
            value += config.getId();
        }

        return value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        final var name = new StringBuilder();
        for (final var config : configs) {
            name.append(config.getName()).append(";");
        }

        name.deleteCharAt(name.indexOf(";"));
        return name.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasNext() {
        return position < configs.size() - 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Config next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        return configs.get(position++);
    }
}
