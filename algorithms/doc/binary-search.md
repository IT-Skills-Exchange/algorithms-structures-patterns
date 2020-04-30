# The Binary Search Algorithm

In computer science, binary search, also known as half-interval search, logarithmic search, or binary chop, is 
a search algorithm that finds the position of a target value within a sorted array. Binary search compares the 
target value to the middle element of the array. If they are not equal, the half in which the target cannot lie is 
eliminated and the search continues on the remaining half, again taking the middle element to compare to the target value, 
and repeating this until the target value is found. If the search ends with the remaining half being empty, 
the target is not in the array.

## Characteristics

- Data must be sorted!
- Chooses the element in the middle of the array and compares it against the search value
- If element is equal to the value, we are done
- If element is grater than the value, search the left half of the array
- If the element is less than the value, search the right half of the array
- At some point, there will be only one element in the partition you're checking, but it does not have to get to that point
- Can be implemented recursively
- O(log n) - keeps dividing the array in half

## Time complexity

Worst-case performance: O(log n)<br>
Best-case performance: O(1)<br>
Average performance: O(log n)<br>
Worst-case space complexity: O(1)

## Implementation

```java
final class BinarySearch {

    static int iterative(final int[] in, final int value) {
        var start = 0;
        var end = in.length;
        while (start < end) {
            final int midpoint = (start + end) / 2;
            if (in[midpoint] == value) {
                return midpoint;
            } else if (in[midpoint] < value) {
                start = midpoint + 1;
            } else {
                end = midpoint;
            }
        }

        return -1;
    }

    static int recursive(final int[] in, final int value) {
        return recursive(in, 0, in.length, value);
    }

    private static int recursive(final int[] in, final int start, final int end, final int value) {
        if (start >= end) {
            return -1;
        }

        final var midpoint = (start + end) / 2;
        if (in[midpoint] == value) {
            return midpoint;
        } else if (in[midpoint] < value) {
            return recursive(in, midpoint + 1, end, value);
        } else {
            return recursive(in, start, midpoint, value);
        }
    }
}
```

## Links

* [Binary Search Algorithm](https://en.wikipedia.org/wiki/Binary_search_algorithm)