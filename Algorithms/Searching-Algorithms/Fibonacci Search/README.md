# Fibonacci Search:
### Definition:
A search algorithm that uses Fibonacci numbers to divide the array into sections for probing. It chooses probe positions based on Fibonacci offsets instead of halving the interval; like binary search but uses additions/subtractions of Fibonacci numbers to compute indices.
**Problem:** Search for `key` in a **sorted** array `arr[]` using Fibonacci-based probes.
**Input:** A sorted array `arr[]` of size `n` and target `key`.
**Output:** Index of `key` if found; otherwise `-1`.
### Algorithm Steps:
1. Generate the smallest Fibonacci number `fibM` such that `fibM >= n` (track `fibM`, `fibM_minus1`, `fibM_minus2`).
2. Set `offset = -1`.
3. While `fibM > 1`:
4. Compute `i = min(offset + fibM_minus2, n - 1)` - probe index.
5. If `arr[i] < key`: move right - set `fibM = fibM_minus1`, `fibM_minus1 = fibM_minus2`, `fibM_minus2 = fibM - fibM_minus1`, and `offset = i`.
6. If `arr[i] > key`: move left - set `fibM = fibM_minus2`, `fibM_minus1 = fibM_minus1 - fibM_minus2`, `fibM_minus2 = fibM - fibM_minus1`.
7. If `arr[i] == key`, return `i`.
8. After loop, if `fibM_minus1 == 1` and `offset + 1 < n` and `arr[offset + 1] == key`, return `offset + 1`.
9. If not found, return `-1`.
### Key characteristics:
Similar complexity to binary search (`O(log n)`) but uses Fibonacci numbers to pick probe indices. Historically useful where only addition/subtraction and array indexing are cheap operations (avoid division). Good for systems with slow mid computations or to guarantee certain probe patterns.
### Time Complexity:
1. **Best Case:** `O(1)` - found on first probe.
2. **Average Case:** `O(log n)`.
3. **Worst Case:** `O(log n)`.
