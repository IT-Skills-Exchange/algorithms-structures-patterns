package com.github.akarazhev.tutorial.designpatterns.memento;

/**
 * Provides the implementation of an environment that has a version.
 */
final class Environment {
    private int version;

    /**
     * Returns an environment version.
     *
     * @return a version
     */
    public int getVersion() {
        return version;
    }

    /**
     * Sets an environment version.
     *
     * @param version a version.
     */
    public void setVersion(final int version) {
        this.version = version;
    }

    /**
     * Creates a snapshot based on a version.
     *
     * @return a snapshot.
     */
    public Snapshot create() {
        return new Snapshot(version);
    }

    /**
     * Restores a version based on a snapshot.
     *
     * @param snapshot a snapshot.
     */
    public void restore(final Snapshot snapshot) {
        this.version = snapshot.getVersion();
    }
}
