# The Linear Search Algorithm

In computer science, a linear search or sequential search is a method for finding an element within a list. 
It sequentially checks each element of the list until a match is found or the whole list has been searched.

## Characteristics

- A linear search runs in at worst linear time and makes at most n comparisons, where n is the length of the list.

## Time complexity

Worst-case performance:	O(n)<br>
Best-case performance: O(1)<br>
Average performance: O(n)<br>
Worst-case space complexity: O(1) iterative

## Implementation

```java
final class LinearSearch {

    static int search(final int[] in, final int value) {
        for (var i = 0; i < in.length; i++) {
            if (in[i] == value) {
                return i;
            }
        }

        return -1;
    }
}
```

## Links

* [Linear Search Algorithm](https://en.wikipedia.org/wiki/Linear_search)