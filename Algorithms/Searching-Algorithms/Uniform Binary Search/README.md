# Uniform Binary Search (UBS):
### Definition:
A variant of binary search that uses a precomputed table of “offsets” (probe distances) so each step uses additions/indexing rather than computing `mid = low + (high-low)/2`. It is an iterative, table-driven form of binary search often used to avoid division or variable mid computation.
**Problem:** Search for `key` in a sorted array `arr[]`, using uniform probes derived from the array size.
**Input:** A sorted array `arr[]` of size `n` and target `key`. (Precompute a small table for offsets up to `n`.)
**Output:** Index of `key` if found, otherwise `-1`.
### Algorithm Steps (high-level):
1. Precompute a table of offsets (for sizes up to `n`) that indicate where to probe next - the table encodes the sequence of midpoints for successive interval sizes.
2. Set `index = initial_offset_for_n` and `low = 0`.
3. Compare `arr[index]` with `key`.
4. If equal, return `index`.
5. If `arr[index] < key`, move `low = index + 1` and select the next offset for the reduced size (using the table) to compute new `index`.
6. If `arr[index] > key`, shrink the considered size and pick the next offset accordingly.
7. Repeat until offsets are exhausted; return `-1` if not found.
### Key characteristics:
Avoids runtime division or variable midpoint computation by using precomputed probe offsets. Useful on hardware where division is expensive or for highly optimized, low-level implementations. Logic and complexity match binary search.
### Time Complexity:
1. **Best Case:** `O(1)` - found at the first probe.
2. **Average Case:** `O(log n)` - probes reduce interval exponentially.
3. **Worst Case:** `O(log n)`.
