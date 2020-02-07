package com.github.akarazhev.tutorial.designpatterns.Iterator;

import com.github.akarazhev.tutorial.designpatterns.composite.Configs;
import com.github.akarazhev.tutorial.designpatterns.composite.UserConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Provides the iterator test for configs.
 */
@DisplayName("Configs test")
final class ConfigsTest {

    @Test
    @DisplayName("Iterate")
    void iterate() {
        final var configs = new Configs();
        configs.add(new UserConfig(1001, "Name 1"));
        configs.add(new UserConfig(1002, "Name 2"));
        configs.add(new UserConfig(1003, "Name 3"));

        var position = 1;
        while (configs.hasNext()) {
            final var config = configs.next();
            assertEquals(1000 + position, config.getId());
            assertEquals("Name " + position, config.getName());
            position++;
        }
    }
}
