package com.github.akarazhev.tutorial.datastructures;

import java.util.Objects;

/**
 * It's a simple employee model.
 */
public final class Employee {
    private final int id;
    private final String firstName;
    private final String lastName;

    /**
     * Constructs an employee model with required parameters.
     *
     * @param id        an identifier.
     * @param firstName a first name.
     * @param lastName  a last name.
     */
    public Employee(final int id, final String firstName, final String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Returns an identifier of the employee.
     *
     * @return an identifier.
     */
    public int getId() {
        return id;
    }

    /**
     * Returns a first name of the employee.
     *
     * @return a first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns a last name of the employee.
     *
     * @return a last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final var employee = (Employee) o;
        return id == employee.id &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
