package com.github.akarazhev.tutorial.designpatterns.flyweight;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Provides factory methods to create a db server test.
 */
@DisplayName("DbServers test")
final class DbServersTest {

    @Test
    @DisplayName("Start a new H2db server")
    void startNewH2dbServer() throws Exception {
        final var dbServers = new DbServers();
        final var dbServer = dbServers.newDbServer(ServerType.H2DB);
        assertNotNull(dbServer);
    }
}
