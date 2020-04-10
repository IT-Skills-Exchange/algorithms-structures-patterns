package com.github.akarazhev.tutorial.datastructures.doublylinkedlist;

import com.github.akarazhev.tutorial.datastructures.Employee;

/**
 * Provides a simple doubly linked list implementation.
 */
final class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    /**
     * Adds a node model to front.
     *
     * @param employee an employee.
     */
    void addToFront(final Employee employee) {
        final var node = new Node(employee);
        if (head == null) {
            tail = node;
        } else {
            head.setPrevious(node);
            node.setNext(head);
        }

        head = node;
        size++;
    }

    /**
     * Adds a node model to end.
     *
     * @param employee an employee.
     */
    void addToEnd(final Employee employee) {
        final var node = new Node(employee);
        if (tail == null) {
            head = node;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
        }

        tail = node;
        size++;
    }

    /**
     * Removes a node model from front.
     *
     * @return a node.
     */
    Node removeFromFront() {
        if (isEmpty()) {
            return null;
        }

        final var node = head;
        if (head.getNext() == null) {
            tail = null;
        } else {
            head.getNext().setPrevious(null);
        }

        head = head.getNext();
        size--;
        node.setNext(null);
        return node;
    }

    /**
     * Removes a node model from end.
     *
     * @return a node.
     */
    Node removeFromEnd() {
        if (isEmpty()) {
            return null;
        }

        final var node = tail;
        if (tail.getPrevious() == null) {
            head = null;
        } else {
            tail.getPrevious().setNext(null);
        }

        tail = tail.getPrevious();
        size--;
        node.setPrevious(null);
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
            builder.append(" <=> ");
            current = current.getNext();
        }

        builder.append("null");
        return builder.toString();
    }

    private final static class Node {
        private Employee employee;
        private Node next;
        private Node previous;

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

        Node getPrevious() {
            return previous;
        }

        void setPrevious(final Node previous) {
            this.previous = previous;
        }

        @Override
        public String toString() {
            return employee.toString();
        }
    }
}
