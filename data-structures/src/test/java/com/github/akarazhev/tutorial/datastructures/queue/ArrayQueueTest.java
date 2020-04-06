package com.github.akarazhev.tutorial.datastructures.queue;

import com.github.akarazhev.tutorial.datastructures.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Provides a test methods for a array queue.
 */
@DisplayName("Array queue test")
final class ArrayQueueTest {

    @Test
    @DisplayName("Tests an array queue")
    void testArrayQueue() {
        final var janeJones = new Employee(123, "Jane", "Jones");
        final var johnDoe = new Employee(4567, "John", "Doe");
        final var marySmith = new Employee(22, "Mary", "Smith");
        final var mikeWilson = new Employee(3245, "Mike", "Wilson");
        final var billEnd = new Employee(78, "Bill", "End");

        final var queue = new ArrayQueue(10);
        queue.add(janeJones);
        queue.add(johnDoe);
        queue.add(marySmith);
        queue.add(mikeWilson);
        queue.add(billEnd);
        System.out.println(queue);
        assertEquals(5, queue.size());

        queue.remove();
        queue.remove();
        System.out.println(queue);
        assertEquals(3, queue.size());

        assertEquals("Mary", queue.peek().getFirstName());
        queue.remove();
        queue.remove();
        queue.remove();
        assertEquals(0, queue.size());
        queue.add(mikeWilson);
        System.out.println(queue);
        assertEquals(1, queue.size());
    }
}
