package com.github.akarazhev.tutorial.datastructures.doublylinkedlist;

import com.github.akarazhev.tutorial.datastructures.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Provides a test methods for a doubly linked list.
 */
@DisplayName("Doubly Linked list test")
final class DoublyLinkedListTest {

    @Test
    @DisplayName("Tests an employee doubly linked list")
    void testEmployeeDoublyLinkedList() {
        final var janeJones = new Employee(123, "Jane", "Jones");
        final var johnDoe = new Employee(4567, "John", "Doe");
        final var marySmith = new Employee(22, "Mary", "Smith");
        final var mikeWilson = new Employee(3245, "Mike", "Wilson");

        final var list = new DoublyLinkedList();
        list.addToFront(janeJones);
        list.addToFront(johnDoe);
        list.addToFront(marySmith);
        list.addToFront(mikeWilson);

        System.out.println(list);
        assertEquals(4, list.getSize());

        final var billEnd = new Employee(78, "Bill", "End");
        list.addToEnd(billEnd);
        System.out.println(list);
        assertEquals(5, list.getSize());

        list.removeFromFront();
        System.out.println(list);
        assertEquals(4, list.getSize());

        list.removeFromEnd();
        System.out.println(list);
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

        final var list = new LinkedList<>();
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
