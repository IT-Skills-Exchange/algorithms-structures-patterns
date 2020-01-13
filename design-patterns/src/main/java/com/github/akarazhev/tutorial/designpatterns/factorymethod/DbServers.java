package com.github.akarazhev.tutorial.designpatterns.factorymethod;

import java.sql.SQLException;

/**
 * Provides factory methods to create a db server.
 */
public final class DbServers {

    private DbServers() {
        throw new AssertionError("Factory class can not be created.");
    }

    /**
     * Returns a default H2db server.
     *
     * @return a h2db server.
     * @throws SQLException when a db server encounters a problem.
     */
    public static DbServer newH2dbServer() throws SQLException {
        return new H2dbServer();
    }
}
