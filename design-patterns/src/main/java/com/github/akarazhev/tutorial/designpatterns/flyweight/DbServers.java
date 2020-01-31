package com.github.akarazhev.tutorial.designpatterns.flyweight;

import com.github.akarazhev.tutorial.designpatterns.factorymethod.DbServer;
import com.github.akarazhev.tutorial.designpatterns.factorymethod.H2dbServer;

import java.sql.SQLException;
import java.util.EnumMap;
import java.util.Map;

/**
 * Provides factory methods to create a db server.
 */
final class DbServers {
    private final Map<ServerType, DbServer> servers;

    /**
     * Constructs a DB servers factory.
     */
    public DbServers() {
        servers = new EnumMap<>(ServerType.class);
    }

    /**
     * Returns a db server.
     *
     * @param type a type of the server.
     * @return a h2db server.
     * @throws SQLException when a db server encounters a problem.
     */
    public DbServer newDbServer(final ServerType type) throws SQLException {
        var server = servers.get(type);
        if (server == null) {
            switch (type) {
                case H2DB:
                    server = new H2dbServer();
                    servers.put(type, server);
                    break;
                default:
                    break;
            }
        }

        return server;
    }
}
