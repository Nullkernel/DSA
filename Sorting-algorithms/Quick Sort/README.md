# Quick sort:
## What it is?
Quick sort is a divide-and-conquer sorting algorithm that partitions an array around a pivot so that elements less than the pivot go left and greater go right, then recursively sorts the partitions.
## Algorithm (step-by-step):
1. Choose a pivot element (common choices: first, last, random, median-of-three).
2. Partition the array into two parts: elements `≤` pivot on one side and elements `≥` pivot on the other (partition schemes: `Lomuto`, Hoare).
3. Recursively apply quick sort to the left and right partitions.
4. (Optional) Use tail-recursion elimination or sort smaller partition first to limit recursion depth. Many implementations fall back to insertion sort for tiny subarrays.
## Time complexity:
- Best case: `O(n log n)` - partitions split evenly.
- Average case: `O(n log n)`.
- Worst case: `O(n^2)` - bad pivots repeatedly (e.g., always choose min/max on already sorted data).
## Space complexity:
- Auxiliary / stack: `O(log n)` on average (recursion).
- Worst-case stack depth: `O(n)` if partitions are maximally unbalanced.
### Other notes:
- Not stable by default (swaps can change relative order).
- Typically in-place (needs only `O(1)` extra array space).
- Excellent practical performance and cache behavior; pivot selection and randomization are important to avoid worst-case behavior.
- Common production improvement: _introsort_ (quick sort with a fallback to heap sort if recursion gets too deep).
