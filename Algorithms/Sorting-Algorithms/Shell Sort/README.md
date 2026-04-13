# Shell sort:
## What it is?
Shell sort generalizes insertion sort by first sorting elements far apart (using a gap), then progressively reducing the gap until performing a final insertion-sort pass with `gap = 1`. This reduces large-scale disorder quickly.
## Algorithm (step-by-step):
1. Choose a gap sequence (common sequences: `n/2, n/4, ...`; `Ciura` sequence is a practical choice).
2. For each gap value `g` (from large to `1`):
    - Perform a gapped insertion sort: treat elements `i, i+g, i+2g, ...` as a subarray and insertion-sort them.
3. Continue until `g = 1`, after which a final regular insertion sort finishes the job.
## Time complexity:
- Depends strongly on the chosen gap sequence; there is no single tight bound that covers all sequences.
- Empirically, good gap sequences give substantially better than `O(n^2)` on average (practical average often between roughly `O(n^{1.25})` and `O(n^{1.5})`, depending on sequence and input).
- Worst-case complexity can be as bad as `O(n^2)` for simple gap sequences; some special sequences have proven sub-quadratic worst-case bounds.
## Space complexity:
- Auxiliary: `O(1)` - in-place.
### Other notes:
- Not stable.
- In-place and fairly simple to implement.
- Adaptive to a degree because later passes benefit from prior gapped sorts.
- Often very fast for medium-sized arrays and used as a low-overhead improvement over plain insertion sort.
- Performance and guarantees depend on gap choice; using well-studied sequences (e.g., `Ciura`) gives good practical performance.
