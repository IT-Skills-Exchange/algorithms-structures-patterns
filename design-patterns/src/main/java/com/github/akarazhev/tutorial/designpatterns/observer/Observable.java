package com.github.akarazhev.tutorial.designpatterns.observer;

/**
 * The specification of the observable.
 *
 * @param <T> a type of a data.
 */
interface Observable<T> {
    /**
     * Registers a new observer.
     *
     * @param o an observer.
     */
    void registerObserver(final Observer<T> o);

    /**
     * Removes an observer.
     *
     * @param o an observer
     */
    void removeObserver(final Observer<T> o);

    /**
     * Notifies all observers
     */
    void notifyObservers();
}
