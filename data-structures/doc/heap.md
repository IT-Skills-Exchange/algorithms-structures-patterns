# The Heap Data Structure

In computer science, a heap is a specialized tree-based data structure which is essentially an almost complete tree that 
satisfies the heap property: in a max heap, for any given node C, if P is a parent node of C, then the key (the value) of 
P is greater than or equal to the key of C. In a min heap, the key of P is less than or equal to the key of C. 
The node at the "top" of the heap (with no parents) is called the root node.

## Characteristics

- A complete binary tree
- Must satisfy the heap property
- Max heap: Every parent is greater than or equal to its children 
- Min heap: Every parent is less than or equal to its children
- A binary heap must be a complete tree
- Children are added at each level from left to right
- Usually implemented as arrays 
- The maximum or minimum value will always be at the root of the tree - the advantage of using a heap
- Heapify: process of converting a binary tree into a heap - this often has to be done after an insertion or deletion
- No required ordering between siblings   

## Operation and time complexity

Heaps as Arrays

* We can store binary heaps as arrays
* We put the root at array[0]
* We then traverse each level from left to right, and so the left child of the root would go into array[1], 
its right child would to into array[2], etc.

Insert into Heap

* Always add new items to the end of the array
* Then we have to fix the heap (heapify)
* We compare the new item against its parent
* If the item is greater than its parent, we swap it with its parent
* We then then rinse and repeat 

Let's create a simple heap:

```java
```

It can be used as follow:

```java
```