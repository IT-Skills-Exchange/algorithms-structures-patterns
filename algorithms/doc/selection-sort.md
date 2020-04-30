# The Selection Sort Algorithm

The algorithm divides the input list into two parts: a sorted sublist of items which is built up from left to right at 
the front (left) of the list and a sublist of the remaining unsorted items that occupy the rest of the list. 
Initially, the sorted sublist is empty and the unsorted sublist is the entire input list. The algorithm proceeds by 
finding the smallest (or largest, depending on sorting order) element in the unsorted sublist, exchanging (swapping) 
it with the leftmost unsorted element (putting it in sorted order), and moving the sublist boundaries one element 
to the right.

## Characteristics

- In-place algorithm
- It will take 100 steps to sort 10 items, 10000 steps to sort 100 items, 1000000 steps to sort 1000 items
- Algorithm degrades quickly 
- Does not require as much swapping as bubble sort
- Unstable algorithm

## Time complexity

Worst-case performance:	О(n^2) comparisons, О(n) swaps<br>
Best-case performance: О(n^2) comparisons, О(n) swaps<br>
Average performance: О(n^2) comparisons, О(n) swaps<br>
Worst-case space complexity: O(1) auxiliary

## Implementation

```java
static int[] sort(final int[] in) {
    for (var lastUnsortedIndex = in.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
        var largest = 0;
        for (var i = 1; i <= lastUnsortedIndex; i++) {
            if (in[i] > in[largest]) {
                largest = i;
            }
        }

        Sort.swap(in, largest, lastUnsortedIndex);
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

* [Selection Sort Algorithm](https://en.wikipedia.org/wiki/Selection_sort)