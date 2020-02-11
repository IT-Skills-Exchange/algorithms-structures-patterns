package com.github.akarazhev.tutorial.designpatterns.memento;

/**
 * Provides a buffer to store a snapshot.
 */
final class Buffer {
    private Snapshot snapshot;

    /**
     * Returns a current snapshot.
     *
     * @return a snapshot.
     */
    public Snapshot getSnapshot() {
        return snapshot;
    }

    /**
     * Sets a current snapshot.
     *
     * @param snapshot a snapshot.
     */
    public void setSnapshot(final Snapshot snapshot) {
        this.snapshot = snapshot;
    }
}
