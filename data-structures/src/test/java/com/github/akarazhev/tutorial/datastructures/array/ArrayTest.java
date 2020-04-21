package com.github.akarazhev.tutorial.datastructures.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Provides a test methods for an array.
 */
@DisplayName("Array test")
final class ArrayTest {

    @Test
    @DisplayName("Gets an element with an index")
    void getWithIndex() {
        final var numbers = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        final var value = numbers[5];

        assertEquals(5, value);
    }

    @Test
    @DisplayName("Gets an element without an index")
    void getWithoutIndex() {
        final var numbers = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        final var value = 10;

        var index = -1;
        for (var i = 0; i < numbers.length; i++) {
            if (value == numbers[i]) {
                index = i;
                break;
            }
        }

        assertEquals(10, index);
    }

    @Test
    @DisplayName("Adds an index to a full array")
    void addIndexToFull() {
        final var numbers = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        final var newNumbers = new int[numbers.length + 1];

        System.arraycopy(numbers, 0, newNumbers, 0, numbers.length);

        newNumbers[newNumbers.length - 1] = 11;

        assertEquals(11, newNumbers[newNumbers.length - 1]);
    }

    @Test
    @DisplayName("Adds an element to the end")
    void addToEnd() {
        final var numbers = new int[4];
        numbers[0] = 0;
        numbers[1] = 1;
        numbers[2] = 2;

        numbers[numbers.length - 1] = 3;

        assertEquals(3, numbers[numbers.length - 1]);
    }

    @Test
    @DisplayName("Updates an element with an index")
    void updateWithIndex() {
        final var numbers = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        numbers[4] = 14;

        assertEquals(14, numbers[4]);
    }

    @Test
    @DisplayName("Deletes an element with an index")
    void deleteWithIndex() {
        final var numbers = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        numbers[4] = null;

        assertNull(numbers[4]);
    }

    @Test
    @DisplayName("Deletes an element by shifting elements")
    void deleteByShifting() {
        final var numbers = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        final var newNumbers = new int[numbers.length - 1];

        System.arraycopy(numbers, 0, newNumbers, 0, newNumbers.length);

        assertEquals(9, newNumbers[newNumbers.length - 1]);
    }
}
