package com.github.akarazhev.tutorial.datastructures.stack;

import com.github.akarazhev.tutorial.datastructures.Employee;

import java.util.LinkedList;

/**
 * Provides a simple linked list stack implementation.
 */
final class LinkedStack {
    private final LinkedList<Employee> stack;

    /**
     * Constructs a linked list stack.
     */
    LinkedStack() {
        stack = new LinkedList<>();
    }

    /**
     * Pushes an employee on the tof the stack.
     *
     * @param employee an employee.
     */
    void push(final Employee employee) {
        stack.push(employee);
    }

    /**
     * Pops an employee from the top the stack.
     *
     * @return an employee.
     */
    Employee pop() {
        return stack.pop();
    }

    /**
     * Peeks an employee.
     *
     * @return an employee.
     */
    Employee peek() {
        return stack.peek();
    }

    /**
     * Checks if a list is empty.
     *
     * @return true if it's empty.
     */
    boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        final var builder = new StringBuilder();
        for (Employee employee : stack) {
            builder.append("=>").append(employee);
        }

        return builder.toString();
    }
}
