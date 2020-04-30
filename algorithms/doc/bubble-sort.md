# The Bubble Sort Algorithm

Bubble sort, sometimes referred to as sinking sort, is a simple sorting algorithm that repeatedly steps through the list, 
compares adjacent elements and swaps them if they are in the wrong order. The pass through the list is repeated until 
the list is sorted. The algorithm, which is a comparison sort, is named for the way smaller or larger elements "bubble" 
to the top of the list.

This simple algorithm performs poorly in real world use and is used primarily as an educational tool. 
More efficient algorithms such as timsort, or merge sort are used by the sorting libraries built into popular 
programming languages such as Python and Java.

## Characteristics

- In-place algorithm
- It will take 100 steps to sort 10 items, 10000 steps to sort 100 items, 1000000 steps to sort 1000 items
- Algorithm degrades quickly 
- Stable algorithm

## Time complexity

Worst-case performance: O(n^2) comparisons, O(n^2) swaps<br>
Best-case performance: O(n) comparisons, O(1) swaps<br>
Average performance: O(n^2) comparisons, O(n^2) swaps<br>
Worst-case space complexity: O(n) total, O(1) auxiliary

## Implementation

```java
static int[] sort(final int[] in) {
    for (var lastUnsortedIndex = in.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
        for (var i = 0; i < lastUnsortedIndex; i++) {
            if (in[i] > in[i + 1]) {
                Sort.swap(in, i, i + 1);
            }
        }
    }

    return in;
}

static void swap(final int[] in, final int i, final int j) {
    if (i == j) {
        return;
    }

    final var temp = in[i];
    in[i] = in[j];
    in[j] = temp;
}
```

## Links

* [Bubble Sort Algorithm](https://en.wikipedia.org/wiki/Bubble_sort)