package com.github.akarazhev.tutorial.designpatterns.state;

/**
 * Provides the implementation for an online state.
 */
final class Online implements State {
    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(Context context, String command) {
        if ("pause".equals(command)) {
            context.setState(new Paused());
        } else if ("stop".equals(command)) {
            context.setState(new Offline());
        }
    }
}
