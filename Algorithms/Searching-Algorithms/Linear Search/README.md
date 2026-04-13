# Linear Search:
### Definition: 
It is the simplest searching algorithm that checks every element in a list sequentially until it finds the target element or reaches the end of the list. It doesn't require the data to be sorted and works well on small or unsorted data.
**Problem**: Search for a given element (`key`) on an array using the linear search technique.
**Input**: An array `arr[]` of size n and a target element key.
**Output**: Index of the `key` is found, otherwise returns `-1`.
### Algorithm Steps:
1. Start from the first element of the array.
2. Compare the current element with the target element key.
3. If the current element matches key, return the index.
4. If not, move to the next element.
5. Repeat steps `2` and `4` until the end of the array is reached.
6. If no match is found after traversing the entire array, return `-1`.
### Time Complexity:
1. **Best Case:** `O(1)`  :
  The element is found at the **first position**.
2. **Average Case:** `O(n)`:  
  The element is found somewhere in the **middle**.
3. **Worst Case:** `O(n)`  :
  The element is **last** or **not present** in the list.
