package com.github.akarazhev.tutorial.designpatterns.chainofresponsibility;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Provides a test for the security context.
 */
@DisplayName("Security context test")
final class SecurityContextTest {

    @Test
    @DisplayName("Filter requests")
    void filterRequest() {
        final var context = SecurityContext.defaultContext(SecurityContext.AccessLevel.all()).
                next(SecurityContext.userContext(SecurityContext.AccessLevel.USER)).
                next(SecurityContext.systemContext(SecurityContext.AccessLevel.SYSTEM, SecurityContext.AccessLevel.USER));

        context.filter(SecurityContext.AccessLevel.SYSTEM, "First request.");
        context.filter(SecurityContext.AccessLevel.APPLICATION, "Second request.");
        context.filter(SecurityContext.AccessLevel.USER, "Third request.");
    }
}
