# The Linked List Data Structure

In computer science, a linked list is a linear collection of data elements, whose order is not given by their physical 
placement in memory. Instead, each element points to the next. It is a data structure consisting of a collection of 
nodes which together represent a sequence. In its most basic form, each node contains: data, and a reference 
(in other words, a link) to the next node in the sequence. This structure allows for efficient insertion or 
removal of elements from any position in the sequence during iteration. More complex variants add additional links, 
allowing more efficient insertion or removal of nodes at arbitrary positions. 
A drawback of linked lists is that access time is linear (and difficult to pipeline). 
Faster access, such as random access, is not feasible. Arrays have better cache locality compared to linked lists.

## Characteristics

- Each item in the list is called a node
- The first item in the list is the head of the list

## Operations and time complexity

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

Let's create a simple linked list model:

```java
final class LinkedList {
    private Node head;
    private int size;

    void add(final Employee employee) {
        final var node = new Node(employee);
        node.setNext(head);
        head = node;
        size++;
    }

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

    int getSize() {
        return size;
    }

    boolean isEmpty() {
        return head == null;
    }

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
```

It can be used as follow:

```java
final var janeJones = new Employee(123, "Jane", "Jones");
final var johnDoe = new Employee(4567, "John", "Doe");
final var marySmith = new Employee(22, "Mary", "Smith");
final var mikeWilson = new Employee(3245, "Mike", "Wilson");

final var list = new LinkedList();
assertTrue(list.isEmpty());

list.add(janeJones);
list.add(johnDoe);
list.add(marySmith);
list.add(mikeWilson);
System.out.println(list);
assertEquals(4, list.getSize());

list.remove();
System.out.println(list);
assertEquals(3, list.getSize());
```

## Links

* [Linked List Data Structure](https://en.wikipedia.org/wiki/Linked_list)