package com.github.akarazhev.tutorial.designpatterns.factorymethod;

import org.h2.tools.Server;

import java.sql.SQLException;

/**
 * Provides basic implementation for the h2db server.
 */
public final class H2dbServer implements DbServer {
    private final Server server;

    /**
     * Constructs a default h2db server.
     *
     * @throws SQLException when a h2db server encounters a problem.
     */
    public H2dbServer() throws SQLException {
        this.server = Server.createTcpServer("-tcp", "-tcpPort", "8043", "-ifNotExists");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DbServer start() throws SQLException {
        if (!server.isRunning(true)) {
            server.start();
        }

        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void stop() {
        if (server.isRunning(true)) {
            server.stop();
        }
    }
}
