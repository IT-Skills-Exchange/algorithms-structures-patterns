package com.github.akarazhev.tutorial.designpatterns.command;

/**
 * Provides a pop action.
 */
final class PopAction implements Action {
    private final Storage storage;

    /**
     * Constructs a pop action with the storage.
     *
     * @param storage a storage.
     */
    public PopAction(final Storage storage) {
        this.storage = storage;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute() {
        return storage.pop();
    }
}
