package com.github.akarazhev.tutorial.designpatterns.observer;

/**
 * The specification of the observer.
 *
 * @param <T> a type of a data.
 */
public interface Observer<T> {
    /**
     * Updates a state with a new data.
     *
     * @param data a data to process
     */
    void update(final T data);
}
