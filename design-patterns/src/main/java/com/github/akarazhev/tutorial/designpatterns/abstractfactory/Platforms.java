package com.github.akarazhev.tutorial.designpatterns.abstractfactory;

/**
 * Provides a factory method to create an appropriate platform.
 */
final class Platforms {
    public enum Type {
        EMBEDDED,
        STANDALONE
    }

    /**
     * Returns the new platform based on the type.
     *
     * @param type a type of the platform.
     * @return the appropriate platform.
     */
    public static Platform newPlatform(final Type type) {
        switch (type) {
            case EMBEDDED:
                return new EmbeddedPlatform();
            case STANDALONE:
                return new StandAlonePlatform();
            default:
                throw new IllegalArgumentException(type.name() + " not supported.");
        }
    }
}
