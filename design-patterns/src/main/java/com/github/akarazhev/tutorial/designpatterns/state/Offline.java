package com.github.akarazhev.tutorial.designpatterns.state;

/**
 * Provides the implementation for an offline state.
 */
final class Offline implements State {
    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(final Context context, final String command) {
        if ("start".equals(command)) {
            context.setState(new Online());
        }
    }
}
