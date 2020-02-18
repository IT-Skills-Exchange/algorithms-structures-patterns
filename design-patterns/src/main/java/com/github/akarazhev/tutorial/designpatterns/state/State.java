package com.github.akarazhev.tutorial.designpatterns.state;

/**
 * The specification of the state.
 */
public interface State {
    /**
     * Executes a command and changes a state.
     *
     * @param context a context.
     * @param command a command.
     */
    void execute(final Context context, final String command);
}
