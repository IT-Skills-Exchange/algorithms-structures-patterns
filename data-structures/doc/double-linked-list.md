# The Double Linked List Data Structure

In computer science, a doubly linked list is a linked data structure that consists of a set of sequentially linked 
records called nodes. Each node contains three fields: two link fields (references to the previous and to the next node 
in the sequence of nodes) and one data field. The beginning and ending nodes' previous and next links, respectively, 
point to some kind of terminator, typically a sentinel node or null, to facilitate traversal of the list. 
If there is only one sentinel node, then the list is circularly linked via the sentinel node. It can be conceptualized 
as two singly linked lists formed from the same data items, but in opposite sequential orders.

## Characteristics

- Each item in the list has next and previous fields
- The list has a head and a tail

## Operations and time complexity

Insert at head, Insert at tail, Delete from head, Delete from tail: O(1) <br>
Insert between nodes, Remove between nodes: O(1) time complexity, but have to find a node first, so it's actually O(n)

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

Let's create a simple doubly linked list implementation:

```java
final class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

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
```

It can be used as follow:

```java
final var janeJones = new Employee(123, "Jane", "Jones");
final var johnDoe = new Employee(4567, "John", "Doe");
final var marySmith = new Employee(22, "Mary", "Smith");
final var mikeWilson = new Employee(3245, "Mike", "Wilson");

final var list = new DoublyLinkedList();
list.addToFront(janeJones);
list.addToFront(johnDoe);
list.addToFront(marySmith);
list.addToFront(mikeWilson);

System.out.println(list);
assertEquals(4, list.getSize());

final var billEnd = new Employee(78, "Bill", "End");
list.addToEnd(billEnd);
System.out.println(list);
assertEquals(5, list.getSize());

list.removeFromFront();
System.out.println(list);
assertEquals(4, list.getSize());

list.removeFromEnd();
System.out.println(list);
assertEquals(3, list.getSize());
```

## Links

* [Double Linked List Data Structure](https://en.wikipedia.org/wiki/Doubly_linked_list)