# The Array Data Structure

In computer science, an array data structure, or simply an array, is a data structure consisting of a collection of 
elements (values or variables), each identified by at least one array index or key. An array is stored such that 
the position of each element can be computed from its index tuple by a mathematical formula. 
The simplest type of data structure is a linear array, also called one-dimensional array.

For example, an array of 10 32-bit (4 bytes) integer variables, with indices 0 through 9, may be stored as 10 words at 
memory addresses 2000, 2004, 2008, …, 2036, so that the element with index i has the address 2000 + (i × 4).

The memory address of the first element of an array is called first address, foundation address, or base address.

## Characteristics

- Contiguous block in memory 
- Every element occupies the same amount of space in memory
- If an array starts at memory address x, and the size if each element in the array is y, we can calculate 
the memory address of the ith element by using the following expression: x + y * y
- If we know the index of an element, the time to retrieve the element will be the same, no matter where it is in 
the array

## Operations and time complexity

Retrieve an element from an array

* Multiply the size of the element by its index
* Get the start address of the array
* Add the start address to the result of the multiplication

Retrieve with an index: O(1)

```java
final var numbers = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
final var value = numbers[5];

assertEquals(5, value);
```

Retrieve without an index: O(n)

```java
final var numbers = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
final var value = 10;

var index = -1;
for (var i = 0; i < numbers.length; i++) {
    if (value == numbers[i]) {
        index = i;
        break;
    }
}

assertEquals(10, index);
```

Add an index to a full array: O(n)

```java
final var numbers = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
final var newNumbers = new int[numbers.length + 1];

System.arraycopy(numbers, 0, newNumbers, 0, numbers.length);

newNumbers[newNumbers.length - 1] = 11;

assertEquals(11, newNumbers[newNumbers.length - 1]);
```

Add an element to the end of an array (has space): O(1) 

```java
final var numbers = new int[4];
numbers[0] = 0;
numbers[1] = 1;
numbers[2] = 2;

numbers[numbers.length - 1] = 3;

assertEquals(3, numbers[numbers.length - 1]);
```

Insert or update an element at a specific index: O(1) 

```java
final var numbers = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
numbers[4] = 14;

assertEquals(14, numbers[4]);
```

Delete an element by setting it to null: O(1)
 
 ```java
final var numbers = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
numbers[4] = null;

assertNull(numbers[4]);
 ```
 
Delete an element by shifting elements: O(n) 

```java
final var numbers = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
final var newNumbers = new int[numbers.length - 1];

System.arraycopy(numbers, 0, newNumbers, 0, newNumbers.length);

assertEquals(9, newNumbers[newNumbers.length - 1]);
```

## Links

* [Array Data Structure](https://en.wikipedia.org/wiki/Array_data_structure)