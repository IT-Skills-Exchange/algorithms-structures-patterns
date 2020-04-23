package com.github.akarazhev.tutorial.datastructures.linkedlist;

import com.github.akarazhev.tutorial.datastructures.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Provides a test methods for a linked list.
 */
@DisplayName("Linked list test")
final class LinkedListTest {

    @Test
    @DisplayName("Tests an employee linked list")
    void testEmployeeLinkedList() {
        final var janeJones = new Employee(123, "Jane", "Jones");
        final var johnDoe = new Employee(4567, "John", "Doe");
        final var marySmith = new Employee(22, "Mary", "Smith");
        final var mikeWilson = new Employee(3245, "Mike", "Wilson");

        final var list = new LinkedList();
        assertTrue(list.isEmpty());

        list.add(janeJones);
        list.add(johnDoe);
        list.add(marySmith);
        list.add(mikeWilson);
        System.out.println(list);
        assertEquals(4, list.getSize());

        list.remove();
        System.out.println(list);
        assertEquals(3, list.getSize());
    }
}
