package com.github.akarazhev.tutorial.datastructures.hashtable;

import com.github.akarazhev.tutorial.datastructures.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    @DisplayName("Tests a chained hashtable")
    void testChainedHashtable() {
        final var janeJones = new Employee(123, "Jane", "Jones");
        final var johnDoe = new Employee(4567, "John", "Doe");
        final var marySmith = new Employee(22, "Mary", "Smith");
        final var mikeWilson = new Employee(3245, "Mike", "Wilson");

        final var hashtable = new ChainedHashtable();
        hashtable.put("Jones", janeJones);
        hashtable.put("Doe", johnDoe);
        hashtable.put("Wilson", mikeWilson);
        hashtable.put("Smith", marySmith);
        System.out.println(hashtable);
        assertEquals(4, hashtable.size());

        var value = hashtable.get("Smith");
        assertNotNull(value);
        assertEquals("Mary", value.getFirstName());

        hashtable.remove("Doe");
        hashtable.remove("Jones");
        System.out.println(hashtable);
        assertEquals(2, hashtable.size());
    }

    @Test
    @DisplayName("Tests a hash map")
    void testHashMap() {
        final var janeJones = new Employee(123, "Jane", "Jones");
        final var johnDoe = new Employee(4567, "John", "Doe");
        final var marySmith = new Employee(22, "Mary", "Smith");
        final var mikeWilson = new Employee(3245, "Mike", "Wilson");

        final var hashMap = new HashMap<String, Employee>();
        hashMap.put("Jones", janeJones);
        hashMap.put("Doe", johnDoe);
        hashMap.put("Smith", marySmith);
        // final var employee = hashMap.put("Doe", mikeWilson);
        final var employee = hashMap.putIfAbsent("Doe", mikeWilson);
        assertNotNull(employee);
        assertEquals(4567, employee.getId());

        assertEquals(3245, hashMap.getOrDefault("someone", mikeWilson).getId());
        assertEquals(123, hashMap.remove("Jones").getId());

        assertTrue(hashMap.containsKey("Doe"));
        assertFalse(hashMap.containsValue(janeJones));

        for (Employee value : hashMap.values()) {
            System.out.println(value);
        }

        hashMap.forEach((k, v) -> System.out.println("Key = " + k + ", Employee = " + v));
    }
}
