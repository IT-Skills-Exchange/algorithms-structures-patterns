package com.github.akarazhev.tutorial.datastructures.heap;

/**
 * Provides a simple heap implementation.
 */
final class Heap {
    private final int[] heap;
    private int size;

    /**
     * Constructs a heap model.
     *
     * @param capacity a capacity
     */
    public Heap(final int capacity) {
        heap = new int[capacity];
    }

    /**
     * Inserts a value into a heap.
     *
     * @param value a value.
     */
    void insert(final int value) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Heap is full");
        }

        heap[size] = value;
        fixHeapAbove(size);
        size++;
    }

    /**
     * Peeks a value from a heap.
     *
     * @return a value.
     */
    int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        return heap[0];
    }

    /**
     * Deletes a value from a heap.
     *
     * @param index an index.
     * @return a deleted value.
     */
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

    /**
     * Sorts a heap.
     */
    void sort() {
        final var lastIndex = size - 1;
        for (var i = 0; i < lastIndex; i++) {
            final var tmp = heap[0];
            heap[0] = heap[lastIndex - i];
            heap[lastIndex - i] = tmp;

            fixHeapBelow(0, lastIndex - i - 1);
        }
    }

    /**
     * {@inheritDoc}
     */
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
