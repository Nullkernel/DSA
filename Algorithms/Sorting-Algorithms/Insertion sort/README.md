# Insertion Sort:
## What it is?
Insertion Sort builds a sorted section of the array one element at a time. For each element, it inserts that element into the correct place among elements already sorted to its left.
## Algorithm (step-by-step):
Given array `A[0..n-1]`:
1. For `i = 1` to `n-1`:
2. `key = A[i]`
3. `j = i - 1`
4. While `j >= 0` and `A[j] > key`: set `A[j+1] = A[j]` and `j = j - 1`.
5. Set `A[j+1] = key`.
## Time complexity:
- **Best case:** `O(n)` - array already sorted (only one comparison per element).
- **Average case:** `O(n^2)`.
- **Worst case:** `O(n^2)` - array reverse-sorted.
## Space complexity:
- Auxiliary: `O(1)` - in-place.
### Other notes:
- **Stable:** Yes.
- **Adaptive:** Yes - performs much better on nearly-sorted inputs (useful in hybrid sorts like Timsort).
- **When to use:** Small or nearly-sorted datasets; as the final pass in hybrid sorts.
