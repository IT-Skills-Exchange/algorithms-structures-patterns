package com.github.akarazhev.tutorial.designpatterns.bridge;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Provides the basic transaction implementation.
 */
public final class LockTransaction implements Transaction {
    private final Lock lock = new ReentrantLock();

    /**
     * {@inheritDoc}
     */
    @Override
    public void begin() {
        if (lock.tryLock()) {
            lock.lock();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void end() {
        if (!lock.tryLock()) {
            lock.unlock();
        }
    }
}
