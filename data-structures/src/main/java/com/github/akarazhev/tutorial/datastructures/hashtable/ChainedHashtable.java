package com.github.akarazhev.tutorial.datastructures.hashtable;

import com.github.akarazhev.tutorial.datastructures.Employee;

import java.util.LinkedList;

/**
 * Provides a chained hashtable implementation.
 */
final class ChainedHashtable {
    private LinkedList<KeyValuePair>[] hashtable;

    /**
     * Constructs a hashtable model.
     */
    ChainedHashtable() {
        hashtable = new LinkedList[10];
        for (var i = 0; i < hashtable.length; i++) {
            hashtable[i] = new LinkedList<>();
        }
    }

    /**
     *  Puts a new key-value pair into the hashtable.
     *
     * @param key a key.
     * @param value a value.
     */
    void put(final String key, final Employee value) {
        int hashedKey = hashKey(key);
        hashtable[hashedKey].add(new KeyValuePair(key, value));
    }

    /**
     * Gets a value by a key from the hashtable.
     *
     * @param key a key.
     * @return a value.
     */
    Employee get(final String key) {
        KeyValuePair employee;
        final var hashedKey = hashKey(key);
        for (final var keyValuePair : hashtable[hashedKey]) {
            employee = keyValuePair;
            if (employee.key.equals(key)) {
                return employee.getValue();
            }
        }

        return null;
    }

    /**
     * Removes a value from the hashtable.
     *
     * @return a value.
     */
    Employee remove(final String key) {
        var index = -1;
        KeyValuePair employee = null;
        final var hashedKey = hashKey(key);
        for (final var keyValuePair : hashtable[hashedKey]) {
            employee = keyValuePair;
            index++;
            if (employee.key.equals(key)) {
                break;
            }
        }

        if (employee == null) {
            return null;
        } else {
            hashtable[hashedKey].remove(index);
            return employee.getValue();
        }
    }

    /**
     * Returns a size of the hashtable.
     *
     * @return a size.
     */
    int size() {
        var size = 0;
        for (final var keyValuePairs : hashtable) {
            if (keyValuePairs != null) {
                size += keyValuePairs.size();
            }
        }

        return size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        final var builder = new StringBuilder();
        for (var i = 0; i < hashtable.length; i++) {
            if (hashtable[i].isEmpty()) {
                builder.append("Position ").append(i).append(": Empty");
            } else {
                builder.append("Position ").append(i).append(": ");
                for (final var keyValuePair : hashtable[i]) {
                    builder.append(keyValuePair.getValue()).append("->");
                }

                builder.append("null");
            }
        }

        return builder.toString();
    }

    private int hashKey(final String key) {
        // return key.length() % hashtable.length;
        return Math.abs(key.hashCode() % hashtable.length);
    }

    private final static class KeyValuePair {
        private final String key;
        private final Employee value;

        KeyValuePair(final String key, final Employee value) {
            this.key = key;
            this.value = value;
        }

        String getKey() {
            return key;
        }

        Employee getValue() {
            return value;
        }
    }
}
