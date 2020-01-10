package com.github.akarazhev.tutorial.designpatterns.factorymethod;

/**
 * Provides basic methods for the server.
 */
public interface Server {
    /**
     * Starts the server and returns an instance.
     *
     * @return the server.
     */
    Server start();

    /**
     * Stops the server
     */
    void stop();
}
