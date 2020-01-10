package com.github.akarazhev.tutorial.designpatterns.factorymethod;

import java.net.InetSocketAddress;

/**
 * Provides basic implementation for the http server.
 */
final class HttpServer implements Server {
    private com.sun.net.httpserver.HttpServer httpServer;

    public HttpServer() throws Exception {
        httpServer = com.sun.net.httpserver.HttpServer.create();
        httpServer.bind(new InetSocketAddress(8080), 0);
        httpServer.createContext("/", exchange -> exchange.sendResponseHeaders(200, 0));
        httpServer.setExecutor(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Server start() {
        httpServer.start();
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void stop() {
        httpServer.stop(0);
    }
}
