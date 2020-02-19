package com.github.akarazhev.tutorial.designpatterns.state;

/**
 * Provides the implementation for an online state.
 */
final class Online implements State {
    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(final Context context, final String command) {
        if ("pause".equals(command)) {
            context.setState(new Paused());
        } else if ("stop".equals(command)) {
            context.setState(new Offline());
        }
    }
}
