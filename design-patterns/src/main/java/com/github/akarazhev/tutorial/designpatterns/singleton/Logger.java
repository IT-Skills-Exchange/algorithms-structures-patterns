package com.github.akarazhev.tutorial.designpatterns.singleton;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * The logger singleton instance.
 */
public enum Logger {
    INSTANCE;
    private final AtomicInteger level = new AtomicInteger(0);

    /**
     * Returns a value of the level.
     *
     * @return a level value.
     */
    public int getLevel() {
        return level.get();
    }

    /**
     * Sets a value of the level.
     *
     * @param level a level value.
     */
    public void setLevel(final int level) {
        this.level.set(level);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Logger{" +
                "level=" + level +
                '}';
    }
}