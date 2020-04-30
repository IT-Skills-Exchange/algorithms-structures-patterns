# The Radix Sort Algorithm

In computer science, radix sort is a non-comparative sorting algorithm. It avoids comparison by creating and 
distributing elements into buckets according to their radix. For elements with more than one significant digit, 
this bucketing process is repeated for each digit, while preserving the ordering of the prior step, 
until all digits have been considered. For this reason, radix sort has also been called bucket sort and digital sort.

Radix sort can be applied to data that can be sorted lexicographically, be they integers, words, punch cards, 
playing cards, or the mail.

## Characteristics

- Makes assumptions about the data
- Data must have same radix and width
- Because of this, data must be integers or strings
- Sort based on each individual digit or letter position
- Start at the rightmost position - must use a stable sort algorithm at each stage
- Counting sort is often used as the sort algorithm for radix sort - must be stable counting sort
- In-place depends on which sort algorithm you use
- Stable algorithm

## Time complexity

Worst-case performance:	O(w * n), where w is the number of bits required to store each key.<br>
Worst-case space complexity: O(w + n)

## Implementation

```java
static int[] sort(final int[] in) {
    for (var i = 0; i < 4; i++) {
        sort(in, i, 10);
    }

    return in;
}

private static void sort(final int[] in, final int position, final int radix) {
    final var length = in.length;
    final var counter = new int[radix];

    for (var value: in) {
        counter[getDigit(position, value, radix)]++;
    }
    // Adjust the count array
    for (var j = 1; j < radix; j++) {
        counter[j] += counter[j - 1];
    }

    final var buffer = new int[length];
    for (var i = length - 1; i >= 0; i--) {
        buffer[--counter[getDigit(position, in[i], radix)]] = in[i];
    }

    System.arraycopy(buffer, 0, in, 0, length);
}

private static int getDigit(final int position, final int value, final int radix) {
    return value / (int) Math.pow(radix, position) % radix;
}
```

## Links

* [Radix Sort Algorithm](https://en.wikipedia.org/wiki/Radix_sort)