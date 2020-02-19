package com.github.akarazhev.tutorial.designpatterns.templatemethod;

import java.util.Collection;

/**
 * Provides the implementation for a data loader.
 */
abstract class DataLoader {
    /**
     * Loads data from the external source.
     *
     * @return a loaded data.
     */
    abstract Collection<Integer> getData();

    /**
     * Returns an encoded data from the external source.
     *
     * @return an encoded data.
     */
    final String getEncoded() {
        final var encoded = new StringBuilder();
        getData().forEach(val -> encoded.append(":").append(val));
        return encoded.length() > 0 ? encoded.deleteCharAt(0).toString() : encoded.toString();
    }
}
