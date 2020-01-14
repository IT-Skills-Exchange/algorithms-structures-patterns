package com.github.akarazhev.tutorial.designpatterns.factorymethod;

import java.net.InetSocketAddress;

/**
 * Provides basic implementation for the http server.
 */
final class HttpServer implements WebServer {
    private final com.sun.net.httpserver.HttpServer httpServer;

    /**
     * Constructs a default http server.
     *
     * @throws Exception when a http server encounters a problem.
     */
    HttpServer() throws Exception {
        final var payload = "pong";
        httpServer = com.sun.net.httpserver.HttpServer.create();
        httpServer.bind(new InetSocketAddress(8080), 0);
        httpServer.createContext("/ping", exchange -> {
            exchange.sendResponseHeaders(200, payload.getBytes().length);

            final var output = exchange.getResponseBody();
            output.write(payload.getBytes());
            output.flush();

            exchange.close();

        });
        httpServer.setExecutor(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebServer start() {
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
