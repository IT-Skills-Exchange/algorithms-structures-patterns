package com.github.akarazhev.tutorial.designpatterns.command;

/**
 * Provides specification for an action.
 */
public interface Action {
    /**
     * Executes an action.
     *
     * @return the result.
     */
    int execute();
}