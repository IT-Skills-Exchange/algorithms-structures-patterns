package com.github.akarazhev.tutorial.datastructures.hashtable;

import com.github.akarazhev.tutorial.datastructures.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Provides a test methods for a hashtable.
 */
@DisplayName("Hashtable test")
final class HashtableTest {

    @Test
    @DisplayName("Tests a simple hashtable")
    void testSimpleHashtable() {
        final var janeJones = new Employee(123, "Jane", "Jones");
        final var johnDoe = new Employee(4567, "John", "Doe");
        final var marySmith = new Employee(22, "Mary", "Smith");
        final var mikeWilson = new Employee(3245, "Mike", "Wilson");
//        final var billEnd = new Employee(78, "Bill", "End");

        final var hashtable = new SimpleHashtable();
        hashtable.put("Jones", janeJones);
        hashtable.put("Doe", johnDoe);
        hashtable.put("Wilson", mikeWilson);
        hashtable.put("Smith", marySmith);
        System.out.println(hashtable);
        assertEquals(4, hashtable.size());

        var value = hashtable.get("Wilson");
        assertNotNull(value);
        assertEquals("Mike", value.getFirstName());

        value = hashtable.get("Smith");
        assertNotNull(value);
        assertEquals("Mary", value.getFirstName());

        hashtable.remove("Wilson");
        hashtable.remove("Jones");
        System.out.println(hashtable);
        assertEquals(2, hashtable.size());

        value = hashtable.get("Smith");
        assertNotNull(value);
        assertEquals("Mary", value.getFirstName());
    }
}
