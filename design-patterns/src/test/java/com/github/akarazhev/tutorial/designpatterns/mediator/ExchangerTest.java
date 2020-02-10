package com.github.akarazhev.tutorial.designpatterns.mediator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Provides the exchanger test for services.
 */
@DisplayName("Exchanger test")
final class ExchangerTest {

    @Test
    @DisplayName("Send")
    void send() {
        final var exchanger = new Exchanger();
        final var systemService = new SystemServiceBean(exchanger);
        final var userService = new UserServiceBean(exchanger);

        exchanger.register(systemService);
        exchanger.register(userService);

        systemService.send("setLevel");
        userService.send("setName");

        assertEquals(1000, systemService.getLevel());
        assertEquals("My Name", userService.getName());
    }
}
