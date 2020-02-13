package com.github.akarazhev.tutorial.designpatterns.state;

/**
 * Provides the implementation for a offline state.
 */
final class Offline implements State {
    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(Context context, String command) {
        if ("start".equals(command)) {
            context.setState(new Online());
        }
    }
}
