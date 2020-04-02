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
    @DisplayName("Tests an employee linked list implementation")
    void testEmployeeLinkedList() {
        final var janeJones = new Employee(123, "Jane", "Jones");
        final var johnDoe = new Employee(4567, "John", "Doe");
        final var marySmith = new Employee(22, "Mary", "Smith");
        final var mikeWilson = new Employee(3245, "Mike", "Wilson");

        final var list = new LinkedList();
        assertTrue(list.isEmpty());

        list.addToFront(janeJones);
        list.addToFront(johnDoe);
        list.addToFront(marySmith);
        list.addToFront(mikeWilson);
        System.out.println(list.toString());
        assertEquals(4, list.getSize());

        list.removeFromFront();
        System.out.println(list.toString());
        assertEquals(3, list.getSize());
    }

    @Test
    @DisplayName("Tests a linked list")
    void testLinkedList() {
        final var janeJones = new Employee(123, "Jane", "Jones");
        final var johnDoe = new Employee(4567, "John", "Doe");
        final var marySmith = new Employee(22, "Mary", "Smith");
        final var mikeWilson = new Employee(3245, "Mike", "Wilson");
        final var billEnd = new Employee(78, "Bill", "End");

        final var list = new java.util.LinkedList<>();
        list.addFirst(janeJones);
        list.addFirst(johnDoe);
        list.addFirst(marySmith);
        list.addFirst(mikeWilson);

        var iterator = list.iterator();
        System.out.print("HEAD -> ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            System.out.print("<=>");
        }
        System.out.println("null");

        list.addLast(billEnd);
        iterator = list.iterator();
        System.out.print("HEAD -> ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            System.out.print("<=>");
        }
        System.out.println("null");

        list.removeFirst();
        iterator = list.iterator();
        System.out.print("HEAD -> ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            System.out.print("<=>");
        }
        System.out.println("null");

        list.removeLast();
        iterator = list.iterator();
        System.out.print("HEAD -> ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            System.out.print("<=>");
        }
        System.out.println("null");
    }
}
