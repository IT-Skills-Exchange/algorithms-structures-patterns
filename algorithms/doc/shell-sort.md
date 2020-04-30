# The Shell Sort Algorithm

Shellsort, also known as Shell sort or Shell's method, is an in-place comparison sort. It can be seen as either 
a generalization of sorting by exchange (bubble sort) or sorting by insertion (insertion sort). The method starts by 
sorting pairs of elements far apart from each other, then progressively reducing the gap between elements to be compared. 
Starting with far apart elements, it can move some out-of-place elements into position faster than a simple nearest 
neighbor exchange. Donald Shell published the first version of this sort in 1959. The running time of Shellsort is 
heavily dependent on the gap sequence it uses. For many practical variants, determining their time complexity remains 
an open problem.

## Characteristics

- In-place algorithm
- Does not require as much shifting as insertion sort, so it usually performs better
- Unstable algorithm

## Time complexity

Worst-case performance: O(n^2) (worst known worst case gap sequence) O(n log^2 n) (best known worst case gap sequence)<br>
Best-case performance: O(n log n) (most gap sequences) O(n log^2 n) (best known worst-case gap sequence)<br>
Average performance: depends on gap sequence<br>
Worst-case space complexity: О(n) total, O(1) auxiliary

## Implementation

* Variation of Insertion Sort
* Insertion sort chooses which element to insert using a gap of 1
* Shell sort starts out using a large gap value
* As the algorithm runs, the gap is reduced
* Goal is to reduce the amount if shifting required
* As the algorithm progresses, the gap is reduced
* The last gap value is always 1
* A gap value of 1 is equivalent to insertion sort
* So, the algorithm does some preliminary work (using gap values greater than 1), and then becomes insertion sort
* By the time we get to insertion sort, the array has been partially sorted, so there's less shifting required

* Gap is calculated using (3^k - 1) / 2
* We set k based on the length of the array
* We want the gap to be as close as possible to the length of the array we want to sort, 
without being greater than the length 
* We will base our gap on the array's length. We will initialize the gap (or interval) to array.length / 2
* On each iteration, we will divide the gap value by 2 to get the next gap value
* For our array, the gap will be initialized to 3
* On the next iteration, it will be 1 - insertion sort

```java
static int[] sort(final int[] in) {
    for (var gap = in.length / 2; gap > 0; gap /= 2) {
        for (var i = gap; i < in.length; i++) {
            var j = i;
            var newElement = in[i];
            while (j >= gap && in[j - gap] > newElement) {
                in[j] = in[j - gap];
                j -= gap;
            }

            in[j] = newElement;
        }
    }
    
    return in;
}
```

## Links

* [Shell Sort Algorithm](https://en.wikipedia.org/wiki/Shellsort)