package com.github.akarazhev.tutorial.datastructures.linkedlist;

import com.github.akarazhev.tutorial.datastructures.Employee;

/**
 * Provides a simple linked list implementation.
 */
final class LinkedList {
    private Node head;
    private int size;

    /**
     * Adds a node model to front.
     *
     * @param employee an employee.
     */
    void add(final Employee employee) {
        final var node = new Node(employee);
        node.setNext(head);
        head = node;
        size++;
    }

    /**
     * Removes a node model from front.
     *
     * @return a node.
     */
    Node remove() {
        if (isEmpty()) {
            return null;
        }

        final var node = head;
        head = head.getNext();
        size--;
        node.setNext(null);
        return node;
    }

    /**
     * Returns a size of the list.
     *
     * @return a size.
     */
    int getSize() {
        return size;
    }

    /**
     * Checks if a list is empty.
     *
     * @return true if it's empty.
     */
    boolean isEmpty() {
        return head == null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        var current = head;
        final var builder = new StringBuilder();
        builder.append("HEAD -> ");
        while (current != null) {
            builder.append(current);
            builder.append(" -> ");
            current = current.getNext();
        }

        builder.append("null");
        return builder.toString();
    }

    private final static class Node {
        private Employee employee;
        private Node next;

        Node(final Employee employee) {
            this.employee = employee;
        }

        Employee getEmployee() {
            return employee;
        }

        void setEmployee(final Employee employee) {
            this.employee = employee;
        }

        Node getNext() {
            return next;
        }

        void setNext(final Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return employee.toString();
        }
    }
}
