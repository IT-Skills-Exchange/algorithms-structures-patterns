package com.github.akarazhev.tutorial.datastructures.queue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Provides a test methods for a priority queue.
 */
@DisplayName("Priority queue test")
final class PriorityQueueTest {

    @Test
    @DisplayName("Tests a priority queue")
    void testPriorityQueue() {
        final var priorityQueue = new PriorityQueue<Integer>();
        priorityQueue.add(25);
        priorityQueue.add(-22);
        priorityQueue.add(1343);
        priorityQueue.add(54);
        priorityQueue.add(0);
        priorityQueue.add(-3492);
        priorityQueue.add(429);

        assertEquals(-3492, priorityQueue.peek());
        assertEquals(-3492, priorityQueue.remove());
        assertEquals(-22, priorityQueue.peek());
        assertEquals(-22, priorityQueue.poll());
        assertEquals(0, priorityQueue.peek());
        assertTrue(priorityQueue.remove(54));

        final var values = priorityQueue.toArray();
        for (final var value : values) {
            System.out.println(value);
        }

        assertEquals(0, priorityQueue.peek());
        priorityQueue.add(-1);
        assertEquals(-1, priorityQueue.peek());
    }
}
