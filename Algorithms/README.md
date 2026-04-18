# Recursion:  
Recursion is a programming technique in which a function calls itself, either directly or indirectly, to solve a problem by breaking it down into smaller subproblems until a base condition is reached.

---

## Asymptotic Analysis:
As input size grows very large, it becomes impractical to measure an algorithm's exact running time in seconds or steps. Instead we use asymptotic analysis to describe the general trend of an algorithm's performance as input size approaches infinity.
It focuses on dominant factors that influence growth, while ignoring constant multipliers and lower-order terms that have little effect on large inputs.
**This approach allows us to:**
1. Abstract away machine-specific details and implementation differences.
2. Compare algorithms based on their scalability and efficiency.
3. Understand the upper and lower bounds of algorithm performance.
## Types of Asymptotic Notations:
#### Asymptotic notations provide a formal way to describe the growth rates of functions representing an algorithm’s time or space complexity. The main asymptotic notations are:
- **Big-O Notation `(O)`** - Provides an upper bound on the growth rate. It describes the worst-case scenario: the algorithm’s running time will not exceed this bound for sufficiently large inputs.
- **Big-Ω (Omega) Notation `(Ω)`** - Provides a lower bound on the growth rate. It describes the best-case scenario: the running time will be at least this much for sufficiently large inputs.
- **Big-Θ (Theta) Notation `(Θ)`** - Provides a tight (both upper and lower) bound: the algorithm grows at this exact asymptotic rate (within constant factors).
- **little-o Notation `(o)`** - Describes a strict upper bound: `f(n) = o(g(n))` means `f` grows strictly slower than `g` (for any constant `c > 0`, eventually `f(n) < c·g(n)`).
## Space Complexity:
Space complexity refers to the amount of memory (space) an algorithm needs to run to completion. It includes all memory and its usage during execution, including variables, data structures, function calls, and temporary storage.
## Types of Memory Used:
1. **Instruction space** - Memory required to store the compiled version of the program (code).
2. **Activation stack / Call stack** - Space required for function calls: parameters, return addresses, and local variables.
3. **Heap** - Dynamically allocated memory during runtime (objects, dynamic arrays, etc.).
4. **Input/Output data space** - Space required to store input and output data buffers.
## Common Space Complexities:
1. **`O(1)`** - Constant space: the algorithm uses a fixed amount of extra memory regardless of input size.
2. **`O(n)`** - Linear space: auxiliary memory used grows proportionally with input size.
3. **`O(n²)`** - Quadratic space: used by algorithms that store `2D` structures or pairwise data (e.g., some matrix or naive graph algorithms).

---

# Balanced Brackets Code:
## Meaning:
A bracket expression is **balanced** if every opening bracket has a matching closing bracket in the correct order.
Examples:
- `()`, `{[]}`, `((a+b)*c)` → balanced.
- `([)]`, `(((`, `())` → not balanced.
## Idea:
Use a **stack**:
- Push opening brackets: `(`, `{`, `[`.
- When a closing bracket comes:
    - stack must not be empty.
    - top of stack must be the matching opening bracket.
- At the end, stack must be empty.
## Algorithm:
1. Read the expression.
2. For each character:
    - If it is an opening bracket, push it.
    - If it is a closing bracket:
        - If stack is empty, return false.
        - Pop top and check match.
3. If stack is empty after processing all characters, return true.
## Matching pairs:
- `(` matches `)`.
- `{` matches `}`.
- `[` matches `]`.
## Time and Space Complexity:
- Time: `O(n)`.
- Space: `O(n)`.
## Simple pseudocode:
```bash
balanced(expr):  
	create empty stack  
	for each ch in expr:  
		if ch is opening bracket:  
			push ch  
		else if ch is closing bracket:  
			if stack is empty:  
				return false  
			top = pop()  
			if not matching(top, ch):  
				return false  
	return stack is empty
```
