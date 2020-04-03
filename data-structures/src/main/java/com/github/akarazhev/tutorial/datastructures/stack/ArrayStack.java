package com.github.akarazhev.tutorial.datastructures.stack;

import com.github.akarazhev.tutorial.datastructures.Employee;

import java.util.EmptyStackException;

/**
 * Provides a simple array stack implementation.
 */
final class ArrayStack {
    private Employee[] stack;
    private int top;

    /**
     * Constructs an array stack with a required capacity.
     *
     * @param capacity a capacity.
     */
    ArrayStack(final int capacity) {
        stack = new Employee[capacity];
    }

    /**
     * Pushes an employee on the tof the stack.
     *
     * @param employee an employee.
     */
    void push(final Employee employee) {
        if (top == stack.length) {
            // need to resize the backing array
            final var array = new Employee[2 * stack.length];
            System.arraycopy(stack, 0, array, 0, stack.length);
            stack = array;
        }

        stack[top++] = employee;
    }

    /**
     * Pops an employee from the top the stack.
     *
     * @return an employee.
     */
    Employee pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        final var employee = stack[--top];
        stack[top] = null;
        return employee;
    }

    /**
     * Peeks an employee.
     *
     * @return an employee.
     */
    Employee peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return stack[top - 1];
    }

    /**
     * Returns a size of the stack.
     *
     * @return a size.
     */
    int size() {
        return top;
    }

    /**
     * Checks if a list is empty.
     *
     * @return true if it's empty.
     */
    boolean isEmpty() {
        return top == 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        final var builder = new StringBuilder();
        for (int i = top - 1; i >= 0; i--) {
            builder.append("=>").append(stack[i]);
        }

        return builder.toString();
    }
}
