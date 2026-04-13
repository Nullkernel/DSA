# Interpolation Search:
### Definition:
A search technique that estimates the position of the target by interpolating within the range of key values (like guessing where a name would fall in a phone book), rather than always probing the midpoint. Works best when keys are **uniformly distributed** and numeric.
**Problem:** Search for `key` in a **sorted** numeric array `arr[]` using value-based position estimation.
**Input:** A sorted numeric array `arr[]` (values comparable and preferably uniformly distributed) of size `n` and `key`.
**Output:** Index of `key` if found; otherwise `-1`.
### Algorithm Steps:
1. Initialize `low = 0`, `high = n - 1`.
2. While `low <= high` and `key` is within `arr[low]`..`arr[high]`:
3. Estimate `pos = low + ((key - arr[low]) * (high - low)) / (arr[high] - arr[low])`.
4. If `arr[pos] == key`, return `pos`.
5. If `arr[pos] < key`, set `low = pos + 1`.
6. Else set `high = pos - 1`.
7. If element not found, return `-1`.
### Key characteristics:
Best for uniformly distributed numeric data. Probes closer to the likely position - can be much faster than binary search on favorable distributions. Requires arithmetic (division, subtraction) and care when `arr[high] == arr[low]`.
### Time Complexity:
1. **Best Case:** `O(1)` - guessed position is correct immediately.
2. **Average Case:** `O(log log n)` - for uniformly distributed data.
3. **Worst Case:** `O(n)` - for highly skewed distributions or pathological input (degenerates to linear behavior).
