package com.github.akarazhev.tutorial.designpatterns.observer;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Provides the implementation for events generation.
 */
final class Events implements Observable<String> {
    private final List<String> events = new LinkedList<>();
    private final List<Observer<String>> observers = new LinkedList<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public void registerObserver(final Observer<String> o) {
        observers.add(o);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeObserver(final Observer<String> o) {
        observers.remove(o);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void notifyObservers() {
        observers.forEach(observer -> {
            for (final var event : events) {
                observer.update(event);
            }
        });
    }

    /**
     * Generates events.
     */
    public void generate() {
        IntStream.range(0, 5).forEach(value -> events.add("Event_" + value));
        notifyObservers();
    }
}
