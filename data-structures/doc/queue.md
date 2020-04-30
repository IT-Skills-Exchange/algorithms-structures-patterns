# The Queue Data Structure

In computer science, a queue is a collection of entities that are maintained in a sequence and can be modified by 
the addition of entities at one end of the sequence and removal from the other end of the sequence. By convention, 
the end of the sequence at which elements are added is called the back, tail, or rear of the queue and the end at 
which elements are removed is called the head or front of the queue, analogously to the words used when people line up 
to wait for goods or services.

## Characteristics

- Abstract data type
- FIFO - first in, first out
- add - also called enqueue - add an item to the end of the queue
- remove - also called dequeue - remove the item at the front of the queue
- peek - get the item at the front of the queue, but don't remove it

## Time complexity

Average: Space O(n), Search O(n), Insert O(1), Delete O(1) <br>
Worst case: Space O(n), Search O(n), Insert O(1), Delete O(1)

## Operations

Insert, Delete: O(1)

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

Let's create a simple array queue:

```java
final class ArrayQueue {
    private Employee[] queue;
    private int front;
    private int back;

    ArrayQueue(final int capacity) {
        queue = new Employee[capacity];
    }

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

    Employee peek() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        return queue[front];
    }

    int size() {
        if (front <= back) {
            return back - front;
        } else {
            return back - front + queue.length;
        }

    }

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
```

It can be used as follow:

```java
final var janeJones = new Employee(123, "Jane", "Jones");
final var johnDoe = new Employee(4567, "John", "Doe");
final var marySmith = new Employee(22, "Mary", "Smith");
final var mikeWilson = new Employee(3245, "Mike", "Wilson");
final var billEnd = new Employee(78, "Bill", "End");

final var queue = new ArrayQueue(10);
queue.add(janeJones);
queue.add(johnDoe);
queue.add(marySmith);
queue.add(mikeWilson);
queue.add(billEnd);
System.out.println(queue);
assertEquals(5, queue.size());

queue.remove();
queue.remove();
System.out.println(queue);
assertEquals(3, queue.size());

assertEquals("Mary", queue.peek().getFirstName());
queue.remove();
queue.remove();
queue.remove();
assertEquals(0, queue.size());
queue.add(mikeWilson);
System.out.println(queue);
assertEquals(1, queue.size());
```

## Links

* [Queue Data Structure](https://en.wikipedia.org/wiki/Queue_(abstract_data_type))