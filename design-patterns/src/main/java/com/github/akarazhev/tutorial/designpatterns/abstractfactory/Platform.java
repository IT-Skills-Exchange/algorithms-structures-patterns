package com.github.akarazhev.tutorial.designpatterns.abstractfactory;

import com.github.akarazhev.tutorial.designpatterns.factorymethod.DbServer;
import com.github.akarazhev.tutorial.designpatterns.factorymethod.WebServer;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Provides basic methods for a platform.
 */
public interface Platform {
    /**
     * Creates a new db server.
     *
     * @return the db server.
     * @throws SQLException when a db server encounters a problem.
     */
    DbServer newDbServer() throws SQLException;

    /**
     * Creates a new web server.
     *
     * @return the web server.
     * @throws IOException when the web server encounters a problem.
     */
    WebServer newWebServer() throws Exception;
}
