package com.github.akarazhev.tutorial.designpatterns.singleton;

/**
 * The Runtime singleton instance.
 */
final class Runtime {

    private Runtime() {
        // Empty constructor
    }

    /**
     * Returns a singleton instance.
     *
     * @return an instance of the class.
     */
    public static Runtime getInstance() {
        return RuntimeHolder.INSTANCE;
    }

    /**
     * Provides the lazy-loaded Singleton instance.
     */
    private static class RuntimeHolder {
        private static final Runtime INSTANCE = new Runtime();
    }
}