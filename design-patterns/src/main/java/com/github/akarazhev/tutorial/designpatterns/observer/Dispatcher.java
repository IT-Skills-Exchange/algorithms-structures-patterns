package com.github.akarazhev.tutorial.designpatterns.observer;

import java.util.LinkedList;
import java.util.List;

/**
 * Provides the implementation for a dispatcher.
 */
final class Dispatcher implements Observer<String> {
    private final List<String> data = new LinkedList<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final String data) {
        this.data.add(data);
    }

    /**
     * Returns a buffer with a content
     *
     * @return a content.
     */
    public String getBuffer() {
        final var buffer = new StringBuilder();
        data.forEach(string -> buffer.append(string).append(":"));
        buffer.deleteCharAt(buffer.length() - 1);
        buffer.trimToSize();
        return buffer.toString();
    }
}
