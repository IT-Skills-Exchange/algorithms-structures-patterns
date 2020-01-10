package com.github.akarazhev.tutorial.designpatterns.factorymethod;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Servers test")
final class ServersTest {

    @Test
    @DisplayName("Start a new http server")
    void startNewHttpServer() throws Exception {
        final var server = Servers.newHttpServer().start();
        // todo
        server.stop();
    }

    @Test
    @DisplayName("Start a new https server")
    void startNewHttpsServer() throws Exception {
        final var server = Servers.newHttpsServer().start();
        // todo
        server.stop();
    }
}
