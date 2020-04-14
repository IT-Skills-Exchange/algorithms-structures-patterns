package com.github.akarazhev.tutorial.datastructures.hashtable;

import com.github.akarazhev.tutorial.datastructures.Employee;

import java.util.LinkedList;

final class ChainedHashtable {
    private LinkedList<KeyValuePair>[] hashtable;

    ChainedHashtable() {
        hashtable = new LinkedList[10];
        for (var i = 0; i < hashtable.length; i++) {
            hashtable[i] = new LinkedList<>();
        }
    }

    void put(final String key, final Employee employee) {
        int hashedKey = hashKey(key);
        hashtable[hashedKey].add(new KeyValuePair(key, employee));
    }

    Employee get(final String key) {
        KeyValuePair employee;
        final var hashedKey = hashKey(key);
        for (KeyValuePair keyValuePair : hashtable[hashedKey]) {
            employee = keyValuePair;
            if (employee.key.equals(key)) {
                return employee.getValue();
            }
        }

        return null;
    }

    public Employee remove(final String key) {
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

    private int hashKey(final String key) {
        // return key.length() % hashtable.length;
        return Math.abs(key.hashCode() % hashtable.length);
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
