package com.github.akarazhev.tutorial.designpatterns.factorymethod;

import java.net.InetSocketAddress;

/**
 * Provides basic implementation for the http server.
 */
public final class HttpServer implements WebServer {
    private final com.sun.net.httpserver.HttpServer httpServer;

    /**
     * Constructs a default http server with a certain port.
     *
     * @param port a server port.
     * @throws Exception when a http server encounters a problem.
     */
    public HttpServer(final int port) throws Exception {
        final var payload = "pong";
        httpServer = com.sun.net.httpserver.HttpServer.create();
        httpServer.bind(new InetSocketAddress(port), 0);
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
