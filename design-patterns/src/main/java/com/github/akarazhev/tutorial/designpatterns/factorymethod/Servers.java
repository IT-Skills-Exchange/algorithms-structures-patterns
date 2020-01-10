package com.github.akarazhev.tutorial.designpatterns.factorymethod;

import java.io.IOException;

/**
 * Provides factory methods to create servers.
 */
public final class Servers {

    private Servers() {
        throw new AssertionError("Factory class can not be created.");
    }

    /**
     * Returns the http server.
     *
     * @return an instance of the server
     * @throws IOException when the server encounters a problem.
     */
    public static Server newHttpServer() throws Exception {
        return new HttpServer();
    }

    /**
     * Returns the https server.
     *
     * @return an instance of the server
     * @throws IOException when the server encounters a problem.
     */
    public static Server newHttpsServer() throws Exception {
        return new HttpsServer();
    }
}
