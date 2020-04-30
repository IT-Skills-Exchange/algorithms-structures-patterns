# The Counting Sort Algorithm

In computer science, counting sort is an algorithm for sorting a collection of objects according to keys that are 
small integers; that is, it is an integer sorting algorithm. It operates by counting the number of objects that have 
each distinct key value, and using arithmetic on those counts to determine the positions of each key value in the output 
sequence. Its running time is linear in the number of items and the difference between the maximum and minimum key values, 
so it is only suitable for direct use in situations where the variation in keys is not significantly greater than 
the number of items. However, it is often used as a subroutine in another sorting algorithm, radix sort, that can handle 
larger keys more efficiently.

## Characteristics

- Makes assumptions about the data
- Does not use comparisons
- Counts the number of occurrences of each value
- Only works with non-negative discrete values (can not work with floats, strings) 
- Values must be within a specific range
- Not an in-place algorithm
- If we want the sort to be stable, we have to do some extra steps

## Time complexity

Worst-case performance: O(n + k), where k is the range of the non-negative key values.<br>
Worst-case space complexity: O(n + k)

## Implementation

```java
static int[] sort(final int[] in) {
    return sort(in, 1, 10);
}

private static int[] sort(final int[] in, final int min, final int max) {
    final var count = new int[(max - min) + 1];
    for (var i = 0; i < in.length; i++) {
        count[in[i] - min]++;
    }

    var j = 0;
    for (var i = min; i <= max; i++) {
        while (count[i - min] > 0) {
            in[j++] = i;
            count[i - min]--;
        }
    }

    return in;
}
```

## Links

* [Counting Sort Algorithm](https://en.wikipedia.org/wiki/Counting_sort)