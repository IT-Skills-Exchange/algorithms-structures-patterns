package com.github.akarazhev.tutorial.designpatterns.command;

import java.util.HashMap;
import java.util.Map;

/**
 * Provides the action executor implementation to register, execute operations.
 */
final class ActionExecutor {
    private final Map<String, Action> actions = new HashMap<>();

    /**
     * Registers the action with an action name.
     *
     * @param actionName an action name.
     * @param action     an implementation of an action.
     */
    public void register(final String actionName, final Action action) {
        actions.put(actionName, action);
    }

    /**
     * Executes the action by an action name.
     *
     * @param actionName an action name.
     * @return the result.
     */
    public int execute(final String actionName) {
        final var action = actions.get(actionName);
        if (action == null) {
            throw new IllegalStateException("No action registered: " + actionName);
        }

        return action.execute();
    }
}