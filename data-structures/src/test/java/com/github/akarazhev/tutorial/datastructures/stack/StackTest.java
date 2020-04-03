package com.github.akarazhev.tutorial.datastructures.stack;

import com.github.akarazhev.tutorial.datastructures.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Provides a test methods for a array stack and linked list stacks.
 */
@DisplayName("Stack test")
final class StackTest {

    @Test
    @DisplayName("Test array stack")
    void testArrayStack() {
        final ArrayStack stack = new ArrayStack(10);
        stack.push(new Employee(123, "Jane", "Jones"));
        stack.push(new Employee(4567, "John", "Doe"));
        stack.push(new Employee(22, "Mary", "Smith"));
        stack.push(new Employee(3245, "Mike", "Wilson"));
        stack.push(new Employee(78, "Bill", "End"));
        System.out.println(stack);

        assertEquals(5, stack.size());

        assertEquals("Bill", stack.peek().getFirstName());
        assertEquals(5, stack.size());

        assertEquals("Bill", stack.pop().getFirstName());
        assertEquals("Mike", stack.peek().getFirstName());
    }

    @Test
    @DisplayName("Test linked list stack")
    void testLinkedListStack() {
        final var janeJones = new Employee(123, "Jane", "Jones");
        final var johnDoe = new Employee(4567, "John", "Doe");
        final var marySmith = new Employee(22, "Mary", "Smith");
        final var mikeWilson = new Employee(3245, "Mike", "Wilson");
        final var billEnd = new Employee(78, "Bill", "End");

        final LinkedStack stack = new LinkedStack();
        stack.push(janeJones);
        stack.push(johnDoe);
        stack.push(marySmith);
        stack.push(mikeWilson);
        stack.push(billEnd);
        System.out.println(stack);

        assertEquals("Bill", stack.peek().getFirstName());

        assertEquals("Bill", stack.pop().getFirstName());
        assertEquals("Mike", stack.peek().getFirstName());
    }
}
