# Bubble Sort:

## What it is?
Bubble Sort repeatedly scans the array and swaps adjacent elements that are in the wrong order. Each full pass pushes the largest remaining element to its correct position (“bubbles up”) at the end.
## Algorithm (step-by-step):
Given array `A[0..n-1]`:
1. For `pass = 0` to `n-2`:
2. For `i = 0` to `n-2-pass`:
3. If `A[i] > A[i+1]` then swap `A[i]` and `A[i+1]`.
4. Optionally stop early if a pass makes **no swaps** (optimization).
## Time complexity:
- **Best case:** `O(n)` - array already sorted and early-exit optimization used (one pass to confirm).
- **Average case:** `O(n^2)`.
- **Worst case:** `O(n^2)` - array in reverse order.
## Space complexity:
- Auxiliary: `O(1)` - in-place.
### Other notes:
- **Stable:** Yes (preserves relative order of equal elements). 
- **When to use:** Mostly educational or for tiny arrays; simple and stable but inefficient on large datasets.
