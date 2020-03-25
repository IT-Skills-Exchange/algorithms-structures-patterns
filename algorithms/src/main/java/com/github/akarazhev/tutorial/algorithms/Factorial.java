package com.github.akarazhev.tutorial.algorithms;

/**
 * Provides factorial methods.
 */
final class Factorial {
    /**
     * Calculates a factorial recursively.
     *
     * @param num a number to calculate.
     * @return the result.
     */
    static int recursive(final int num) {
        if (num == 0) {
            return 1;
        }

        return num * recursive(num - 1);
    }

    /**
     * Calculates a factorial iteratively.
     *
     * @param num a number to calculate.
     * @return the result.
     */
    static int iterative(final int num) {
        if (num == 0) {
            return 1;
        }

        var value = 1;
        for (var i = 1; i <= num; i++) {
            value *= i;
        }

        return value;
    }
}
