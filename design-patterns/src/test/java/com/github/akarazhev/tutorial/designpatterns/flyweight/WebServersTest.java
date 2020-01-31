package com.github.akarazhev.tutorial.designpatterns.flyweight;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Provides factory methods to create web servers test.
 */
@DisplayName("WebServers test")
final class WebServersTest {

    @Test
    @DisplayName("Start a new http server")
    void startNewHttpServer() throws Exception {
        final var webServers = new WebServers();
        final var webServer = webServers.newWebServer(ServerType.HTTP);
        assertNotNull(webServer);
    }
}
