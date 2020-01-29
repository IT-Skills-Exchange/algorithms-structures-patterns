package com.github.akarazhev.tutorial.designpatterns.factorymethod;

import java.sql.SQLException;

/**
 * Provides basic methods for a db server.
 */
public interface DbServer {
    /**
     * Starts a db server and returns an instance.
     *
     * @return a db server.
     * @throws SQLException when a db server encounters a problem.
     */
    DbServer start() throws SQLException;

    /**
     * Stops a db server.
     */
    void stop();
}
