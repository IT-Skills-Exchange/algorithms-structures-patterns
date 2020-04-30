# The Factorial Algorithm

In mathematics, the factorial of a positive integer n, denoted by n!, is the product of all positive integers less than 
or equal to n: n!=n*(n-1)*(n-2)*... For example: 5! = 5 * 4 * 3 * 2 * 1 = 120. The value of 0! is 1, according to 
the convention for an empty product.

## Implementation

* If num is equal to 0, The factorial is 1. Stop. We have the result. Otherwise...
* Set multiplier to 1
* Set factorial to 1
* While multiplier is not equal to num, do steps 5 and 6
* Multiply factorial by multiplier and assign the result to factorial
* Add 1 to multiplier
* Stop. The result is factorial

Recursive way:
```java
static int recursive(final int num) {
    if (num == 0) {
        return 1;
    }

    return num * recursive(num - 1);
}
```

Iterative way:
```java
static int iterative(final int num) {
    if (num == 0) {
        return 1;
    }

    var value = 1;
    for (var i = 1; i <= num; i++) {
        value *= i;
    }

    return value;
}
```

## Links

* [Factorial Algorithm](https://en.wikipedia.org/wiki/Factorial)