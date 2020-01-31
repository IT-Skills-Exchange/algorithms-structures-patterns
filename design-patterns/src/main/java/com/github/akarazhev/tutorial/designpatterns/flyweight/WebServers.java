package com.github.akarazhev.tutorial.designpatterns.flyweight;

import com.github.akarazhev.tutorial.designpatterns.factorymethod.HttpServer;
import com.github.akarazhev.tutorial.designpatterns.factorymethod.WebServer;

import java.util.EnumMap;
import java.util.Map;

/**
 * Provides factory methods to create a web server.
 */
final class WebServers {
    private final Map<ServerType, WebServer> servers;

    /**
     * Constructs a web servers factory.
     */
    public WebServers() {
        this.servers = new EnumMap<>(ServerType.class);
    }

    /**
     * Returns a web server.
     *
     * @param type a type of the server.
     * @return a http server.
     * @throws Exception when the web server encounters a problem.
     */
    public WebServer newWebServer(final ServerType type) throws Exception {
        var server = servers.get(type);
        if (server == null) {
            switch (type) {
                case HTTP:
                    server = new HttpServer(8081);
                    servers.put(type, server);
                    break;
                default:
                    break;
            }
        }

        return server;
    }
}
