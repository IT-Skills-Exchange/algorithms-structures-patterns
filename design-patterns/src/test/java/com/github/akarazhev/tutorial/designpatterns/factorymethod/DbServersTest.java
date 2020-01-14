package com.github.akarazhev.tutorial.designpatterns.factorymethod;

import com.github.akarazhev.tutorial.designpatterns.UnitTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Provides factory methods to create a db server test.
 */
@DisplayName("DbServers test")
final class DbServersTest extends UnitTest {

    @Test
    @DisplayName("Start a new H2db server")
    void startNewH2dbServer() throws Exception {
        final var server = DbServers.newH2dbServer().start();
        assertGetSchema();
        server.stop();
    }
}
