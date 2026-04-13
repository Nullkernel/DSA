# Selection Sort:
## What it is?
Selection Sort repeatedly selects the minimum element from the unsorted portion and swaps it into the next position of the sorted portion.
## Algorithm (step-by-step):
Given array `A[0..n-1]`:
1. For `i = 0` to `n-2`:
2. `minIndex = i`
3. For `j = i+1` to `n-1`: if `A[j] < A[minIndex]` then `minIndex = j`.
4. Swap `A[i]` and `A[minIndex]` (if `minIndex != i`).
## Time complexity:
- **Best / Average / Worst:** `O(n^2)` - always scans remaining elements to find the minimum.
## Space complexity:
- Auxiliary: `O(1)` - in-place.
### Other notes:
- **Stable:** Not stable by default (swaps can change relative order of equal elements). Can be made stable with additional cost.
- **Adaptive:** No - does not benefit from existing order.
- **When to use:** Rare for large arrays; useful when the number of writes/swaps must be minimized (it does at most `n` swaps).
