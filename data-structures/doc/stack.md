# The Stack Data Structure

In computer science, a stack is an abstract data type that serves as a collection of elements, with two principal 
operations:

- push, which adds an element to the collection, and
- pop, which removes the most recently added element that was not yet removed.

The order in which elements come off a stack gives rise to its alternative name, LIFO (last in, first out). Additionally, 
a peek operation may give access to the top without modifying the stack. The name "stack" for this type of 
structure comes from the analogy to a set of physical items stacked on top of each other, which makes it easy to take an 
item off the top of the stack, while getting to an item deeper in the stack may require taking off multiple other items 
first.

## Characteristics

- Abstract data type
- LIFO - Last in, first out
- push - adds an item as the top item on the stack
- pop - removes the top item on the stack
- peek - gets the top item on the stack without popping it
- If you know the maximum number of items that will ever be on the stack, an array can be a good choice
- If memory is tight, an array might be a good choice
- ideal backing data structure: linked list 

## Operations and time complexity

O(1) for push, pop, and peek, when using a linked list. 

Let's create a simple employee model:

```java
public final class Employee {
    private final int id;
    private final String firstName;
    private final String lastName;

    public Employee(final int id, final String firstName, final String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final var employee = (Employee) o;
        return id == employee.id &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
```

Let's create a simple linked list stack:

```java
final class LinkedStack {
    private final LinkedList<Employee> stack;

    LinkedStack() {
        stack = new LinkedList<>();
    }

    void push(final Employee employee) {
        stack.push(employee);
    }

    Employee pop() {
        return stack.pop();
    }

    Employee peek() {
        return stack.peek();
    }

    boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        final var builder = new StringBuilder();
        final var iterator = stack.listIterator();
        for (Employee employee : stack) {
            builder.append("=>").append(employee);
        }

        return builder.toString();
    }
}
```

It can be used as follow:

```java
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
```

If you use an array, then push is O(n), because the array may have to be resized.

Let's create a simple array stack:

```java
final class ArrayStack {
    private Employee[] stack;
    private int top;

    ArrayStack(final int capacity) {
        stack = new Employee[capacity];
    }

    void push(final Employee employee) {
        if (top == stack.length) {
            // need to resize the backing array
            final var array = new Employee[2 * stack.length];
            System.arraycopy(stack, 0, array, 0, stack.length);
            stack = array;
        }

        stack[top++] = employee;
    }

    Employee pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        final var employee = stack[--top];
        stack[top] = null;
        return employee;
    }

    Employee peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return stack[top - 1];
    }

    int size() {
        return top;
    }

    boolean isEmpty() {
        return top == 0;
    }

    @Override
    public String toString() {
        final var builder = new StringBuilder();
        for (int i = top - 1; i >= 0; i--) {
            builder.append("=>").append(stack[i]);
        }

        return builder.toString();
    }
}
```

It can be used as follow:

```java
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
```

## Links

* [Stack Data Structure](https://en.wikipedia.org/wiki/Stack_(abstract_data_type))