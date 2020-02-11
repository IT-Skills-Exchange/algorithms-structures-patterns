package com.github.akarazhev.tutorial.designpatterns.memento;

/**
 * Provides a snapshot to store a version.
 */
final class Snapshot {
    private final int version;

    /**
     * Constructs a snapshot based on a version.
     *
     * @param version a version.
     */
    public Snapshot(final int version) {
        this.version = version;
    }

    /**
     * Returns a current version.
     *
     * @return a version.
     */
    public int getVersion() {
        return version;
    }
}
