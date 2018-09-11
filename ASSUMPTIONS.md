## Choices and Assumptions

### Solution 
The chosen solution makes use of dynamic programming to workout the minimal path in a given triangle. Starting at the bottom of the triangle, the minimal paths are bubbled up all the way to the top, until there is only one left, which is indeed the miminal.

The data structure chosen to represent the triangle is a matrix `M` where in each row `i` there are exactly `i` elements `M[i][0]... M[i][i - 1]`. Also, for a given element at position `M[i][j]`, its two descendants can be found at positions `M[i + 1][j]` and `M[i + 1][j + 1]`.

The mentioned properties can be used to directly access the elements of the triangle while processing the minimal paths.

### Assumptions
We assume that all the lines composing a triangle can be read from `stdin` before being processed (thus validated). This comes with the downside of having to wait for the whole input to be submitted before detecting any validation error (i.e. non numeric characters in line).
However, on the fly validation is not explicitly required by the exercise and because it adds extra complexity, we can omit it in this implementation.

We assume that the following validation rules are reasonable and sufficient for the purpose of the exercise
* The triangle cannot be empty (no input) 
* Each level of the triangle, represented by a line of input, cannot contain non numerical characters
* Each level `i` of the triangle must have exactly `i` numeric digits

In addition, when validating the triangle input by the user, any error is accumulated so that error reporting can be as exhaustive as possible. 

We assume that the triangle can always fit into memory, thus the data can be eagerly loaded before launching the minimal path calculation. This solution can be adapted to lazily load the data into memory and process accordingly but this is deemed out o scope.

