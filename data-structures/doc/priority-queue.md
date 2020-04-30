# The Priority Queue Data Structure

In computer science, a priority queue is an abstract data type which is like a regular queue or stack data structure, 
but where additionally each element has a "priority" associated with it. In a priority queue, 
an element with high priority is served before an element with low priority. In some implementations, 
if two elements have the same priority, they are served according to the order in which they were enqueued, 
while in other implementations, ordering of elements with the same priority is undefined.

While priority queues are often implemented with heaps, they are conceptually distinct from heaps. A priority queue is 
a concept like "a list" or "a map"; just as a list can be implemented with a linked list or an array, a priority queue 
can be implemented with a heap or a variety of other methods such as an unordered array.

## Operations

```java
final var priorityQueue = new PriorityQueue<Integer>();
priorityQueue.add(25);
priorityQueue.add(-22);
priorityQueue.add(1343);
priorityQueue.add(54);
priorityQueue.add(0);
priorityQueue.add(-3492);
priorityQueue.add(429);

assertEquals(-3492, priorityQueue.peek());
assertEquals(-3492, priorityQueue.remove());
assertEquals(-22, priorityQueue.peek());
assertEquals(-22, priorityQueue.poll());
assertEquals(0, priorityQueue.peek());
assertTrue(priorityQueue.remove(54));

final var values = priorityQueue.toArray();
for (final var value : values) {
    System.out.println(value);
}

assertEquals(0, priorityQueue.peek());
priorityQueue.add(-1);
assertEquals(-1, priorityQueue.peek());
```

## Links

* [Priority Queue Data Structure](https://en.wikipedia.org/wiki/Priority_queue)