# The Quick Sort Algorithm

Quicksort is a divide-and-conquer algorithm. It works by selecting a 'pivot' element from the array and partitioning 
the other elements into two sub-arrays, according to whether they are less than or greater than the pivot. 
The sub-arrays are then sorted recursively. This can be done in-place, requiring small additional amounts of memory 
to perform the sorting.

## Characteristics

- Divide and conquer algorithm
- Recursive algorithm
- Uses a pivot element to partition the array into two parts
- Elements < pivot to its left, elements > pivot to its right
- Pivot will then be in its correct sorted position
- Process is now repeated for the left array and right array 
- Eventually, every element has been the pivot, so every element will be in its correct sorted position
- As with merge sort, we will end up partitioning the array into a series of 1-element array
- Does this in-place (unlike merge sort)
- In-place algorithm
- Unstable algorithm

## Time complexity

Worst-case performance:	O(n^2)<br>
Best-case performance: O(n log n) (simple partition) or O(n) (three-way partition and equal keys)<br>
Average performance: O(n log n)<br>
Worst-case space complexity: O(n) auxiliary (naive) O(log n) auxiliary (Sedgewick 1978)

## Implementation

```java
static int[] sort(final int[] in) {
    return sort(in, 0, in.length);
}

private static int[] sort(final int[] in, final int start, final int end) {
    if (end - start < 2) {
        return in;
    }

    final var pivot = partition(in, start, end);
    sort(in, start, pivot);
    sort(in, pivot + 1, end);
    return in;
}

private static int partition(int[] in, int start, int end) {
    // This is using the first element as the pivot
    int i = start;
    int j = end;
    final var pivot = in[start];
    while (i < j) {
        // NOTE: empty loop body
        while (i < j && in[--j] >= pivot) ;
        if (i < j) {
            in[i] = in[j];
        }
        // NOTE: empty loop body
        while (i < j && in[++i] <= pivot) ;
        if (i < j) {
            in[j] = in[i];
        }
    }

    in[j] = pivot;
    return j;
}
```

## Links

* [Quick Sort Algorithm](https://en.wikipedia.org/wiki/Quicksort)