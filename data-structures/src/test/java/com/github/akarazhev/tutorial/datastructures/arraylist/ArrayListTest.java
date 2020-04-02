package com.github.akarazhev.tutorial.datastructures.arraylist;

import com.github.akarazhev.tutorial.datastructures.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Provides a test methods for an array list.
 */
@DisplayName("Array list test")
final class ArrayListTest {

    @Test
    @DisplayName("Test array list")
    void testArrayList() {
        final var employeeList = new ArrayList<>();
        employeeList.add(new Employee(123, "Jane", "Jones"));
        employeeList.add(new Employee(4567, "John", "Doe"));
        employeeList.add(new Employee(22, "Mary", "Smith"));
        employeeList.add(new Employee(3245, "Mike", "Wilson"));
        assertEquals(4, employeeList.size());

        employeeList.set(1, new Employee(4568, "John", "Adams"));
        employeeList.add(3, new Employee(4567, "John", "Doe"));
        assertEquals(5, employeeList.size());

        assertTrue(employeeList.contains(new Employee(22, "Mary", "Smith")));
        assertEquals(3, employeeList.indexOf(new Employee(4567, "John", "Doe")));

        employeeList.remove(2);
        assertEquals(4, employeeList.size());
    }
}
