package com.github.akarazhev.tutorial.designpatterns.decorator;

import com.github.akarazhev.tutorial.designpatterns.adapter.Config;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Provides the application config decorator test.
 */
@DisplayName("Application config test")
final class AppConfigTest {

    @Test
    @DisplayName("Create an application config")
    void createAppConfig() {
        final var basedConfig = new Config() {
            @Override
            public int getId() {
                return 100;
            }

            @Override
            public String getName() {
                return "Name";
            }
        };

        final var appConfig = new AppConfig(1, new UserConfig(UUID.randomUUID(), new SystemConfig(basedConfig)));
        assertEquals(100, appConfig.getId());
        assertEquals(1, appConfig.getVersion());
        assertEquals("Name", appConfig.getName());
    }
}
