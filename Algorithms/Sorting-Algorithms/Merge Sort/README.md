# Merge sort:
## What it is?
Merge sort is a divide-and-conquer algorithm that splits the array in halves, recursively sorts each half, and then merges the two sorted halves.
## Algorithm (step-by-step):
1. If the array has `0` or `1` element, it is sorted (base case).
2. Split the array into two halves.
3. Recursively sort each half.
4. Merge the two sorted halves into a single sorted array using a linear-time merge pass.
## Time complexity:
- Best case: `O(n log n)`.
- Average case: `O(n log n)`.
- Worst case: `O(n log n)`.
## Space complexity:
- Auxiliary: `O(n)` for array-based merge (needs temporary buffer to merge).
- For linked lists, merge can be done with `O(1)` extra space by re-linking nodes (so space depends on data structure).
### Other notes:
- Stable by nature (if merging preserves order of equal elements).
- Predictable runtime and great for external sorting and parallelization.
- Not in-place for arrays (standard array-based merge requires `O(n)` extra).
- Good choice when worst-case guarantees and stability are required.
