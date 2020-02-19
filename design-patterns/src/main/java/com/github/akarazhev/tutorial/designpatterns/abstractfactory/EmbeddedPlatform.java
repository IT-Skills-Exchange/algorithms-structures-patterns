package com.github.akarazhev.tutorial.designpatterns.abstractfactory;

import com.github.akarazhev.tutorial.designpatterns.factorymethod.DbServer;
import com.github.akarazhev.tutorial.designpatterns.factorymethod.DbServers;
import com.github.akarazhev.tutorial.designpatterns.factorymethod.WebServer;
import com.github.akarazhev.tutorial.designpatterns.factorymethod.WebServers;

/**
 * Provides basic methods for a embedded platform.
 */
final class EmbeddedPlatform implements Platform {
    /**
     * {@inheritDoc}
     */
    @Override
    public DbServer newDbServer() throws Exception {
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
