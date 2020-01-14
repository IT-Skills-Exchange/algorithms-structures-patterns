package com.github.akarazhev.tutorial.designpatterns.factorymethod;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Provides factory methods to create web servers test.
 */
@DisplayName("WebServers test")
final class WebServersTest {

    @Test
    @DisplayName("Start a new http server")
    void startNewHttpServer() throws Exception {
        final var server = WebServers.newHttpServer().start();
        final var client = HttpClient.newHttpClient();
        final var request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/ping"))
                .GET()
                .build();
        final var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        assertEquals(200, response.statusCode());
        assertEquals("pong", response.body());
        server.stop();
    }
}
