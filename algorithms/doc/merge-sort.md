# The Merge Sort Algorithm

In computer science, merge sort (also commonly spelled mergesort) is an efficient, general-purpose, comparison-based 
sorting algorithm. Most implementations produce a stable sort, which means that the order of equal elements is 
the same in the input and output.

Conceptually, a merge sort works as follows:

1. Divide the unsorted list into n sublists, each containing one element (a list of one element is considered sorted).
2. Repeatedly merge sublists to produce new sorted sublists until there is only one sublist remaining. 
This will be the sorted list.

## Characteristics

- Divide and conquer algorithm
- Recursive algorithm
- Two phases: Splitting and Merging
- Splitting phase leads to faster sorting during the Merging phase
- Splitting is logical. We don't create new arrays
- Not an in-place algorithm
- Stable algorithm

## Time complexity

Worst-case performance:	O(n log n)<br>
Best-case performance: O(n log n) typical, O(n) natural variant<br>
Average performance: O(n log n)<br>
Worst-case space complexity: О(n) total with O(n) auxiliary, O(1) auxiliary with linked lists

## Implementation

Merge Sort - Splitting Phase:

* Start with an unsorted array
* Divide the array into two arrays, which are unsorted. The first array is the left array, and the second array is 
the right array
* Split the left and right arrays into two arrays each
* Keep splitting until all the arrays have only one element each - these arrays are sorted

Merge Sort - Merging Phase:

* Merge every left/right pair of sibling arrays into a sorted array
* After the first merge, we will have a bunch of 2-element sorted arrays
* Then merge those sorted arrays (left/right siblings) to end up with a bunch of 4-element sorted arrays
* Repeat until you have a single sorted array
* Not in place. Uses temporary arrays

Merging process:

* We merge sibling left and right arrays
* We create a temporary array large enough to hold all the elements in the arrays we are merging
* We set i to the first index of the left array, and j to the first index of the right array
* We compare left[j] to right[j]. If left is smaller, we copy it to the temp array and increment i by 1. 
If right is smaller, we copy it to the temp array and increment j by 1.

* We repeat this process until all elements in the two arrays have been processed
* At this point, the temporary array contains the merged values in sorted order
* We then copy this temporary array back to the original input array, at the correct positions
* If the left array is at positions x to y, and the right array is at positions y + 1 to z, then after the copy, 
positions x to z will be sorted in the original array

```java
static int[] sort(final int[] in) {
    return sort(in, 0, in.length);
}

private static int[] sort(final int[] in, final int start, final int end) {
    if (end - start < 2) {
        return in;
    }

    final var mid = (start + end) / 2;
    sort(in, start, mid);
    sort(in, mid, end);
    merge(in, start, mid, end);
    return in;
}

private static void merge(final int[] in, final int start, final int mid, final int end) {
    if (in[mid - 1] <= in[mid]) {
        return;
    }

    var i = start;
    var j = mid;
    var tempIndex = 0;

    final var temp = new int[end - start];
    while (i < mid && j < end) {
        temp[tempIndex++] = in[i] <= in[j] ? in[i++] : in[j++];
    }

    System.arraycopy(in, i, in, start + tempIndex, mid - i);
    System.arraycopy(temp, 0, in, start, tempIndex);
}
```

## Links

* [Merge Sort Algorithm](https://en.wikipedia.org/wiki/Merge_sort)