package com.github.akarazhev.tutorial.designpatterns.factorymethod;

import java.io.IOException;

/**
 * Provides factory methods to create web servers.
 */
public final class WebServers {

    private WebServers() {
        throw new AssertionError("Factory class can not be created.");
    }

    /**
     * Returns the web http server.
     *
     * @return an instance of the web server.
     * @throws IOException when the web server encounters a problem.
     */
    public static WebServer newHttpServer() throws Exception {
        return new HttpServer(8080);
    }
}
