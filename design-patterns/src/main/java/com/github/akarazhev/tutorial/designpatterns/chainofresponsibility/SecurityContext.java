package com.github.akarazhev.tutorial.designpatterns.chainofresponsibility;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.function.Consumer;

/**
 * Provides basic methods for a security context.
 */
@FunctionalInterface
interface SecurityContext {
    /**
     * All available access levels.
     */
    enum AccessLevel {
        SYSTEM, APPLICATION, USER;

        public static AccessLevel[] all() {
            return values();
        }
    }

    /**
     * Filters a request based on the access level.
     *
     * @param level   an access level.
     * @param request an income request.
     */
    void filter(final AccessLevel level, final String request);

    /**
     * Treats a next security context.
     *
     * @param securityContext a security context.
     * @return a security context.
     */
    default SecurityContext next(final SecurityContext securityContext) {
        return (level, request) -> {
            filter(level, request);
            securityContext.filter(level, request);
        };
    }

    /**
     * Creates a security context.
     *
     * @param levels         access levels.
     * @param requestHandler a request handler.
     * @return a security context.
     */
    static SecurityContext context(final AccessLevel[] levels, final Consumer<String> requestHandler) {
        final EnumSet<AccessLevel> accessLevels = EnumSet.copyOf(Arrays.asList(levels));
        return (level, request) -> {
            if (accessLevels.contains(level)) {
                requestHandler.accept(request);
            }
        };
    }

    /**
     * Creates a default security context.
     *
     * @param levels access levels.
     * @return a security context.
     */
    static SecurityContext defaultContext(final AccessLevel... levels) {
        return context(levels, request -> System.out.println("Default context: " + request));
    }

    /**
     * Creates a system security context.
     *
     * @param levels access levels.
     * @return a security context.
     */
    static SecurityContext systemContext(final AccessLevel... levels) {
        return context(levels, request -> System.out.println("System context: " + request));
    }

    /**
     * Creates a user security context.
     *
     * @param levels access levels.
     * @return a security context.
     */
    static SecurityContext userContext(final AccessLevel... levels) {
        return context(levels, request -> System.out.println("User context: " + request));
    }
}