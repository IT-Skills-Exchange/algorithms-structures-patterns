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

## Operations

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
* We then rinse and repeat 

Heaps - Delete

* Must choose a replacement value
* Will take the rightmost value, so that the tree remains complete
* Then we must heapify the heap
* When replacement value is greater than parent, fix heap above. Otherwise, fix heap below
* Fix heap above - same as insert. Swap replacement value with parent
* Fix heap below - swap the replacement value with the larger of its two children
* Rinse and repeat in both cases until the replacement value is in its correct position
* Will only need to fox up or down, not both 

Heap Sort

* We know the root has the largest value
* Swap root with last element in the array
* Heapify the tree, but exclude the last node
* After heapify, second largest element is at the root
* Rinse and repeat

Let's create a simple heap:

```java
final class Heap {
    private final int[] heap;
    private int size;

    public Heap(final int capacity) {
        heap = new int[capacity];
    }

    void insert(final int value) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Heap is full");
        }

        heap[size] = value;
        fixHeapAbove(size);
        size++;
    }

    int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        return heap[0];
    }

    int delete(final int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        var parent = getParent(index);
        var deletedValue = heap[index];
        heap[index] = heap[size - 1];
        if (index == 0 || heap[index] < heap[parent]) {
            fixHeapBelow(index, size - 1);
        } else {
            fixHeapAbove(index);
        }

        size--;
        return deletedValue;
    }

    void sort() {
        final var lastIndex = size - 1;
        for (var i = 0; i < lastIndex; i++) {
            final var tmp = heap[0];
            heap[0] = heap[lastIndex - i];
            heap[lastIndex - i] = tmp;

            fixHeapBelow(0, lastIndex - i - 1);
        }
    }

    @Override
    public String toString() {
        final var builder = new StringBuilder();
        for (var i = 0; i < size; i++) {
            builder.append(heap[i]);
            if (i < size - 1) {
                builder.append(", ");
            }
        }

        return builder.toString();
    }

    private void fixHeapAbove(int index) {
        var newValue = heap[index];
        while (index > 0 && newValue > heap[getParent(index)]) {
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }

        heap[index] = newValue;
    }

    private void fixHeapBelow(int index, final int lastHeapIndex) {
        int childToSwap;
        while (index <= lastHeapIndex) {
            var leftChild = getChild(index, true);
            var rightChild = getChild(index, false);
            if (leftChild <= lastHeapIndex) {
                if (rightChild > lastHeapIndex) {
                    childToSwap = leftChild;
                } else {
                    childToSwap = (heap[leftChild] > heap[rightChild] ? leftChild : rightChild);
                }

                if (heap[index] < heap[childToSwap]) {
                    var tmp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = tmp;
                } else {
                    break;
                }

                index = childToSwap;
            } else {
                break;
            }
        }
    }

    private boolean isFull() {
        return size == heap.length;
    }

    private int getParent(final int index) {
        return (index - 1) / 2;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private int getChild(final int index, final boolean left) {
        return 2 * index + (left ? 1 : 2);
    }
}
```

It can be used as follow:

```java
final var heap = new Heap(10);
heap.insert(80);
heap.insert(75);
heap.insert(60);
heap.insert(68);
heap.insert(55);
heap.insert(40);
heap.insert(52);
heap.insert(67);

var string = heap.toString());
var value = heap.peek();

heap.delete(0);
var string = heap.toString();
var value = heap.peek();
```

## Links

* [Heap Data Structure](https://en.wikipedia.org/wiki/Heap_(data_structure))