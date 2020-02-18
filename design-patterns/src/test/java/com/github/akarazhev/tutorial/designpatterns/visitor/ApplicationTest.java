package com.github.akarazhev.tutorial.designpatterns.visitor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * The application instance test.
 */
@DisplayName("Application test")
final class ApplicationTest {

    @Test
    @DisplayName("Accept")
    void accept() {
        final var app = new Application();
        app.accept(new PerformVisitor());
        app.accept((service, name) -> System.out.println("Test visited: " + name));
    }
}
