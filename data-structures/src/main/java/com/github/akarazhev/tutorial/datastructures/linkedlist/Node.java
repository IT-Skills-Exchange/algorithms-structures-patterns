package com.github.akarazhev.tutorial.datastructures.linkedlist;

import com.github.akarazhev.tutorial.datastructures.Employee;

/**
 * It's a simple node model.
 */
final class Node {
    private Employee employee;
    private Node next;

    /**
     * Constructs a node model with a required parameter.
     *
     * @param employee an employee.
     */
    Node(final Employee employee) {
        this.employee = employee;
    }

    /**
     * Returns an employee model.
     *
     * @return an employee.
     */
    Employee getEmployee() {
        return employee;
    }

    /**
     * Sets an employee model.
     *
     * @param employee an employee.
     */
    void setEmployee(final Employee employee) {
        this.employee = employee;
    }

    /**
     * Returns the next node model.
     *
     * @return a node.
     */
    Node getNext() {
        return next;
    }

    /**
     * Sets the next node model.
     *
     * @param next a node.
     */
    void setNext(final Node next) {
        this.next = next;
    }

    /**
     * {@inheritDoc}
     */
    public String toString() {
        return employee.toString();
    }
}
