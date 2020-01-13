package com.github.akarazhev.tutorial.designpatterns.factorymethod;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("DbServers test")
final class DbServersTest {

    @Test
    @DisplayName("Start a new H2db server")
    void startNewH2dbServer() throws Exception {
        final var server = DbServers.newH2dbServer().start();
        // todo
        server.stop();
    }
}
