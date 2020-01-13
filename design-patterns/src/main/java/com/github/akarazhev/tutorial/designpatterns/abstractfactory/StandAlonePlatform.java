package com.github.akarazhev.tutorial.designpatterns.abstractfactory;

import com.github.akarazhev.tutorial.designpatterns.factorymethod.DbServer;
import com.github.akarazhev.tutorial.designpatterns.factorymethod.DbServers;
import com.github.akarazhev.tutorial.designpatterns.factorymethod.WebServer;
import com.github.akarazhev.tutorial.designpatterns.factorymethod.WebServers;

import java.sql.SQLException;

/**
 * Provides basic methods for a Stand alone platform.
 */
public final class StandAlonePlatform implements Platform {
    /**
     * {@inheritDoc}
     */
    @Override
    public DbServer newDbServer() throws SQLException {
        return DbServers.newH2dbServer();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebServer newWebServer() throws Exception {
        return WebServers.newHttpServer();
    }
}
