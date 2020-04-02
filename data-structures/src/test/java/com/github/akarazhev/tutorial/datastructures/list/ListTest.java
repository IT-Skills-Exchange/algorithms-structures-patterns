package com.github.akarazhev.tutorial.datastructures.list;

import com.github.akarazhev.tutorial.datastructures.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Provides a test methods for a list, array list, vector.
 */
@DisplayName("List test")
final class ListTest {

    @Test
    @DisplayName("Test array list")
    void testArrayList() {
        final List<Employee> employeeList = new ArrayList<>();
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

    @Test
    @DisplayName("Test vector")
    void testVector() {
        final List<Employee> employeeList = new Vector<>();
        employeeList.add(new Employee(123, "Jane", "Jones"));
        employeeList.add(new Employee(4567, "John", "Doe"));
        employeeList.add(new Employee(22, "Mary", "Smith"));
        employeeList.add(new Employee(3245, "Mike", "Wilson"));
        assertEquals(4, employeeList.size());
    }
}
