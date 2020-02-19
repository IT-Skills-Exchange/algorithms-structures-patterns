package com.github.akarazhev.tutorial.designpatterns.prototype;

import com.github.akarazhev.tutorial.designpatterns.builder.Validator;

import java.util.Objects;

/**
 * Simple key-value util object.
 */
final class KeyValuePair<T> implements Cloneable {
    private final String key;
    private final T value;

    /**
     * Constructs a pair model based on a key and value.
     *
     * @param key   a key.
     * @param value a value.
     */
    public KeyValuePair(final String key, final T value) {
        this.key = Validator.of(key).get();
        this.value = Validator.of(value).get();
    }

    /**
     * Returns a pair key pair.
     *
     * @return a key.
     */
    public String getKey() {
        return key;
    }

    /**
     * Returns a pair value.
     *
     * @return a value.
     */
    public T getValue() {
        return value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public KeyValuePair<T> clone() {
        try {
            return (KeyValuePair<T>) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final var that = (KeyValuePair<?>) o;
        return key.equals(that.key) && value.equals(that.value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "KeyValuePair{" +
                "key='" + key + '\'' +
                ", value=" + value +
                '}';
    }
}
