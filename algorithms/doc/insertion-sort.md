# The Insertion Sort Algorithm

Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list. At each iteration, 
insertion sort removes one element from the input data, finds the location it belongs within the sorted list, 
and inserts it there. It repeats until no input elements remain.

## Characteristics

- In-place algorithm
- It will take 100 steps to sort 10 items, 10000 steps to sort 100 items, 1000000 steps to sort 1000 items
- Stable algorithm

## Time complexity

Worst-case performance: О(n^2) comparisons and swaps<br>
Best-case performance: O(n) comparisons, O(1) swaps<br>
Average performance: О(n^2) comparisons and swaps<br>
Worst-case space complexity: О(n) total, O(1) auxiliary

## Implementation

```java
static int[] sort(final int[] in) {
    for (var firstUnsortedIndex = 1; firstUnsortedIndex < in.length; firstUnsortedIndex++) {
        int i;
        var newElement = in[firstUnsortedIndex];
        for (i = firstUnsortedIndex; i > 0 && in[i - 1] > newElement; i--) {
            in[i] = in[i - 1];
        }

        in[i] = newElement;
    }

    return in;
}
```

## Links

* [Insertion Sort Algorithm](https://en.wikipedia.org/wiki/Insertion_sort)