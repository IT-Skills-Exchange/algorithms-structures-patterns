package com.github.akarazhev.tutorial.designpatterns.abstractfactory;

import com.github.akarazhev.tutorial.designpatterns.factorymethod.DbServer;
import com.github.akarazhev.tutorial.designpatterns.factorymethod.WebServer;

/**
 * Provides basic methods for a platform.
 */
interface Platform {
    /**
     * Creates a new db server.
     *
     * @return the db server.
     * @throws Exception when a db server encounters a problem.
     */
    DbServer newDbServer() throws Exception;

    /**
     * Creates a new web server.
     *
     * @return the web server.
     * @throws Exception when the web server encounters a problem.
     */
    WebServer newWebServer() throws Exception;
}
