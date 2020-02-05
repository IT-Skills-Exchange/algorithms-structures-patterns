package com.github.akarazhev.tutorial.designpatterns.command;

/**
 * Provides the storage implementation to push, pop operations.
 */
final class Storage {
    private int value = 0;

    /**
     * Pushes a value to the store.
     *
     * @return a result.
     */
    int push() {
        value = 1000;
        return 1;
    }

    /**
     * Pops a value from the store.
     *
     * @return a value.
     */
    int pop() {
        return value;
    }
}