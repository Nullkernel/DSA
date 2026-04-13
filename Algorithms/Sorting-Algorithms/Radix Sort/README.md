# Radix sort:
## What it is?
Radix sort is a non-comparison sorting method that sorts keys by processing individual digits/parts (e.g., least-significant-digit or most-significant-digit passes), typically using a stable subroutine (like counting sort) per digit.
## Algorithm (step-by-step, LSD variant):
1. Choose a radix/base `k` (e.g., 10 for decimal digits, `256` for bytes) and the number of digit positions `d`.
2. For `pos = 0` (least significant) to `d-1`:
  - Stable-sort the array by the digit at `pos` (counting-sort is usual).
3. After processing all digit positions, the array is fully sorted.
## Time complexity:
- `O(d * (n + k))` where `d = number of digits` and `k = radix` (digit range).
- If `d` and `k` are small constants (fixed-size integers or bounded-length strings), runtime is effectively `O(n)`.
## Space complexity:
- `O(n + k)` auxiliary for counting/buckets (depends on stable subroutine).
### Other notes:
- Not comparison-based; can achieve linear time for fixed-length keys.
- Stable if the per-digit sorting is stable (required for correctness in LSD radix).
- Works best for integers, fixed-length strings, or when key-length/ radix are bounded.
- Careful with memory if `k` is large; choose base to trade off passes vs bucket size.
