package com.github.akarazhev.tutorial.designpatterns.factorymethod;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("WebServers test")
final class WebServersTest {

    @Test
    @DisplayName("Start a new http server")
    void startNewHttpServer() throws Exception {
        final var server = WebServers.newHttpServer().start();
        // todo
        server.stop();
    }

    @Test
    @DisplayName("Start a new https server")
    void startNewHttpsServer() throws Exception {
        final var server = WebServers.newHttpsServer().start();
        // todo
        server.stop();
    }
}
