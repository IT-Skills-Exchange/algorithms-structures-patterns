package com.github.akarazhev.tutorial.datastructures.hashtable;

import com.github.akarazhev.tutorial.datastructures.Employee;

/**
 * Provides a simple hashtable implementation.
 */
final class SimpleHashtable {
    private KeyValuePair[] hashtable;

    /**
     * Constructs a hashtable model.
     */
    SimpleHashtable() {
        hashtable = new KeyValuePair[10];
    }

    /**
     *  Puts a new key-value pair into the hashtable.
     *
     * @param key a key.
     * @param value a value.
     */
    void put(final String key, final Employee value) {
        var hashedKey = hashKey(key);
        if (occupied(hashedKey)) {
            final var stopIndex = hashedKey;
            if (hashedKey == hashtable.length - 1) {
                hashedKey = 0;
            } else {
                hashedKey++;
            }

            while (occupied(hashedKey) && hashedKey != stopIndex) {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        if (occupied(hashedKey)) {
            System.out.println("There's already a value at the position " + hashedKey);
        } else {
            hashtable[hashedKey] = new KeyValuePair(key, value);
        }
    }

    /**
     * Gets a value by a key from the hashtable.
     *
     * @param key a key.
     * @return a value.
     */
    Employee get(final String key) {
        final var hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        }

        return hashtable[hashedKey].getValue();
    }

    /**
     * Removes a value from the hashtable.
     *
     * @return a value.
     */
    Employee remove(final String key) {
        final var hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        }

        final var value = hashtable[hashedKey].getValue();
        hashtable[hashedKey] = null;

        final var oldHashtable = hashtable;
        hashtable = new KeyValuePair[oldHashtable.length];
        for (final var keyValuePair : oldHashtable) {
            if (keyValuePair != null) {
                put(keyValuePair.getKey(), keyValuePair.getValue());
            }
        }

        return value;
    }

    /**
     * Returns a size of the hashtable.
     *
     * @return a size.
     */
    int size() {
        var size = 0;
        for (final var keyValuePair : hashtable) {
            if (keyValuePair != null) {
                size++;
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
            if (hashtable[i] == null) {
                builder.append("Empty");
            } else {
                builder.append("Position ").append(i).append(": ").append(hashtable[i].getValue());
            }
        }

        return builder.toString();
    }

    private boolean occupied(final int index) {
        return hashtable[index] != null;
    }

    private int hashKey(final String key) {
        return key.length() % hashtable.length;
    }

    private int findKey(final String key) {
        var hashedKey = hashKey(key);
        if (hashtable[hashedKey] != null && hashtable[hashedKey].getKey().equals(key)) {
            return hashedKey;
        }

        final var stopIndex = hashedKey;
        if (hashedKey == hashtable.length - 1) {
            hashedKey = 0;
        } else {
            hashedKey++;
        }

        while (hashedKey != stopIndex && hashtable[hashedKey] != null && !hashtable[hashedKey].getKey().equals(key)) {
            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        if (hashtable[hashedKey] != null && hashtable[hashedKey].getKey().equals(key)) {
            return hashedKey;
        } else {
            return -1;
        }
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
