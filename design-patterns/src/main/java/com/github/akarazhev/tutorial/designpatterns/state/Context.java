package com.github.akarazhev.tutorial.designpatterns.state;

/**
 * Provides the implementation for a context.
 */
final class Context {
    private State state;

    /**
     * Constructs a context.
     */
    public Context() {
        state = new Offline();
    }

    /**
     * Sets a state of a context.
     *
     * @param state a state.
     */
    void setState(final State state) {
        this.state = state;
    }

    /**
     * Returns a state of a context.
     *
     * @return a state.
     */
    String getState() {
        return state.getClass().getSimpleName();
    }

    /**
     * Executes a command on a context.
     *
     * @param command a command.
     */
    public void execute(final String command) {
        state.execute(this, command);
    }
}
