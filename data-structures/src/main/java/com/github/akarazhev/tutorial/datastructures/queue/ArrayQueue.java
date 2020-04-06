package com.github.akarazhev.tutorial.datastructures.queue;

import com.github.akarazhev.tutorial.datastructures.Employee;

import java.util.NoSuchElementException;

/**
 * Provides a simple array queue implementation.
 */
final class ArrayQueue {
    private Employee[] queue;
    private int front;
    private int back;

    /**
     * Constructs a queue model with a required parameter.
     *
     * @param capacity a capacity.
     */
    ArrayQueue(final int capacity) {
        queue = new Employee[capacity];
    }

    /**
     * Adds an employee to a queue.
     *
     * @param employee an employee.
     */
    void add(final Employee employee) {
        if (size() == queue.length - 1) {
            final var size = size();
            final var copy = new Employee[2 * queue.length];

            System.arraycopy(queue, front, copy, 0, queue.length - front);
            System.arraycopy(queue, 0, copy, queue.length - front, back);

            queue = copy;
            front = 0;
            back = size;
        }

        queue[back] = employee;
        if (back < queue.length - 1) {
            back++;
        } else {
            back = 0;
        }
    }

    /**
     * Removes an employee from a queue.
     *
     * @return an employee.
     */
    Employee remove() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        final var employee = queue[front];
        queue[front] = null;
        front++;
        if (size() == 0) {
            front = 0;
            back = 0;
        } else if (front == queue.length) {
            front = 0;
        }

        return employee;
    }

    /**
     * Peeks an employee.
     *
     * @return an employee.
     */
    Employee peek() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        return queue[front];
    }

    /**
     * Returns a size of the queue.
     *
     * @return a size.
     */
    int size() {
        if (front <= back) {
            return back - front;
        } else {
            return back - front + queue.length;
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        final var builder = new StringBuilder();
        if (front <= back) {
            for (int i = front; i < back; i++) {
                builder.append(" -> ").append(queue[i]);
            }
        } else {
            for (int i = front; i < queue.length; i++) {
                builder.append(" -> ").append(queue[i]);
            }

            for (int i = 0; i < back; i++) {
                builder.append(" -> ").append(queue[i]);
            }
        }

        return builder.toString();
    }
}
