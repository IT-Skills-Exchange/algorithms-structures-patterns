package com.github.akarazhev.tutorial.datastructures.doublylinkedlist;

import com.github.akarazhev.tutorial.datastructures.Employee;

/**
 * It's a simple node model.
 */
final class Node {
    private Employee employee;
    private Node next;
    private Node previous;

    /**
     * Constructs a node model with a required parameter.
     *
     * @param employee an employee.
     */
    public Node(final Employee employee) {
        this.employee = employee;
    }

    /**
     * Returns an employee model.
     *
     * @return an employee.
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * Sets an employee model.
     *
     * @param employee an employee.
     */
    public void setEmployee(final Employee employee) {
        this.employee = employee;
    }

    /**
     * Returns the next node model.
     *
     * @return a node.
     */
    public Node getNext() {
        return next;
    }

    /**
     * Sets the next node model.
     *
     * @param next a node.
     */
    public void setNext(final Node next) {
        this.next = next;
    }

    /**
     * Returns the previous node model.
     *
     * @return a node.
     */
    public Node getPrevious() {
        return previous;
    }

    /**
     * Sets the previous node model.
     *
     * @param previous a node.
     */
    public void setPrevious(final Node previous) {
        this.previous = previous;
    }

    /**
     * {@inheritDoc}
     */
    public String toString() {
        return employee.toString();
    }
}
