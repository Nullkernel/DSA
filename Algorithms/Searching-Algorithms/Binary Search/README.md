# Binary Search:
### Definition:
A divide-and-conquer search that repeatedly halves a **sorted** array by comparing the target with the middle element and discarding the half that cannot contain the target.		    
**Problem:** Search for a given element (`key`) in a **sorted** array using binary search.
**Input:** A sorted array `arr[]` of size `n` and a target element `key`.		
**Output:** Index where `key` is found; otherwise `-1`.
### Algorithm Steps (iterative):
1. Initialize `low = 0`, `high = n - 1`.
2. While `low <= high`:
3. Compute `mid = low + (high - low) / 2`.
4. If `arr[mid] == key`, return `mid`.
5. If `arr[mid] < key`, set `low = mid + 1`.
6. Else set `high = mid - 1`.
7. If loop exits without finding `key`, return `-1`.
### Key characteristics:
Requires sorted input. Very efficient (logarithmic). Works well for random-access arrays. Simple and stable.	
### Time Complexity:
  1. **Best Case:** `O(1)` - key is at `mid` on first check.
  2. **Average Case:** `O(log n)` - halves the search space each comparison.
  3. **Worst Case:** `O(log n)` - key absent or found after `log₂n` steps.
