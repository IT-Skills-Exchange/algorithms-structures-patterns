# The List, Array List, Vector Data Structures

## List 

An ordered collection (also known as a sequence). The user of this interface has precise control over where in the list 
each element is inserted. The user can access elements by their integer index (position in the list), 
and search for elements in the list.

## Links

* [List Data Structure](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/List.html)

## Array List

Resizable-array implementation of the List interface. Implements all optional list operations, and permits all elements, 
including null. In addition to implementing the List interface, this class provides methods to manipulate the size of 
the array that is used internally to store the list. (This class is roughly equivalent to Vector, except that it is 
unsynchronized.)

### Operations

```java
final List<Employee> employeeList = new ArrayList<>();
employeeList.add(new Employee(123, "Jane", "Jones"));
employeeList.add(new Employee(4567, "John", "Doe"));
employeeList.add(new Employee(22, "Mary", "Smith"));
employeeList.add(new Employee(3245, "Mike", "Wilson"));
assertEquals(4, employeeList.size());

employeeList.set(1, new Employee(4568, "John", "Adams"));
employeeList.add(3, new Employee(4567, "John", "Doe"));
assertEquals(5, employeeList.size());

assertTrue(employeeList.contains(new Employee(22, "Mary", "Smith")));
assertEquals(3, employeeList.indexOf(new Employee(4567, "John", "Doe")));

employeeList.remove(2);
assertEquals(4, employeeList.size());
```

## Links

* [Array List Data Structure](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/ArrayList.html)

## Vector

The Vector class implements a growable array of objects. Like an array, it contains components that can be accessed 
using an integer index. However, the size of a Vector can grow or shrink as needed to accommodate adding and removing 
items after the Vector has been created.

### Operations

```java
final List<Employee> employeeList = new Vector<>();
employeeList.add(new Employee(123, "Jane", "Jones"));
employeeList.add(new Employee(4567, "John", "Doe"));
employeeList.add(new Employee(22, "Mary", "Smith"));
employeeList.add(new Employee(3245, "Mike", "Wilson"));
assertEquals(4, employeeList.size());
```
## Links

* [Vector Data Structure](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Vector.html)

