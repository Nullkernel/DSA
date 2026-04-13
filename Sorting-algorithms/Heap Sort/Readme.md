# Heap Sort:

---

## What is it?
Heap Sort is a comparison-based sorting algorithm that uses a binary heap data structure (usually a max-heap) to sort elements. It works by first building a heap from the array, then repeatedly extracting the maximum element and placing it at the end of the array.
---

## Algorithm(step-by-step):
Step 1: Build Max Heap

- Convert the array into a max heap (parent ≥ children).
- Start from the last non-leaf node and heapify each node up to the root.

Step 2: Extract Elements

- For i = n-1 down to 1:
- Swap A[0] (largest element) with A[i].
- Reduce heap size by 1.
- Heapify the root (A[0]) to maintain heap property.
---

## Time Complexity:
**Best case:** O(n log n)
**Average case:** O(n log n)
**Worst case:** O(n log n)

(Unlike Bubble Sort, Heap Sort performs consistently across all cases.)

---
## Space Complexity:

Auxiliary: O(1) (in-place, no extra memory needed)

---
## Other Notes:

Stable: No (relative order of equal elements may change)

**When to use:**
- Useful when consistent O(n log n) performance is required
- Good for large datasets
- Preferred when memory usage must be minimal
