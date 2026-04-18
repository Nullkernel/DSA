# Stack Data Structure:
**Stack is a linear data structure that follows the Last in First out (LIFO) principle. The element inserted last is the one that is removed first.**

1. ### Characteristics of Stack:
	1. **LIFO Order:** The last inserted element is the first one to be removed.
	2. **Access Restriction:** Only one end, called the top is accessible for insertion  and deletion.
	3. **Dynamic/Static Implementation:** Using arrays (static) or linked list (dynamic).
2. ### Basic Operations:
	1. **`Push`**: Add a element to the top of the stack.
	2. **`Pop`:** Remove a element from top of the stack.
	3. **`Peek/Top`:** Return the top element without removing it.
	4. **`isEmpty`:** Check if the stack is empty.
	5. **`isFull`:** Check if the stack is full.
3. #### Time Complexity: `O(1)`
4. ### Applications:
	1. Reversing a string.
	2. Expression evaluation and conversion.
	3. Backtracking algorithms.
	4. Undo mechanism in editors.
	5. Syntax parsing in compilers.
**Postfix Expression Evaluation:**
- **Read each symbol in the provided postfix expression one at a time, from left to right. If the reading symbol is an operand, push it onto the stack. Otherwise, execute two pop operations and store the two popped operands in two different variables. Next, use operands `1` and `2` to perform a reading symbol action, then push the outcome back onto the stack. Lastly, do a pop operation and show the popped value as the final result.**<br/>
- `Ex:` `(2+3)*4` `=>`
`2 3 + 4 *`

# Arithmetic Expression Evaluation:
## Precedence Rule (or) Operator Precedence:
It determines which operation is performed first in an expression with more than one operator having different precedence.  
For example, in `A + B * C`, multiplication is performed before addition because `*` has higher precedence than `+`.
## Associativity Rule (or) Operator Associativity:
It determines the order of evaluation when two or more operators have the same precedence.
- **Left to right associativity**: the operation on the left is performed first.  
    Example: `A - B - C` is evaluated as `(A - B) - C`
- **Right to left associativity**: the operation on the right is performed first.  
    Example: `A ^ B ^ C` is evaluated as `A ^ (B ^ C)`
For stack-based expression evaluation, precedence and associativity are used to decide whether an operator should be pushed onto the stack or whether operators already in the stack should be popped first.

## Infix to prefix (without stack) for: `a+b*c-d/e^f`
### Step by step, without using a stack
1. `^` has the highest precedence  
    So `e^f` becomes `^ e f`
2. Then `/` and `*`  
    So:
    - `b*c` becomes `* b c`
    - `d/e^f` becomes `/ d ^ e f`
3. Then `+` and `-`  
    The expression is really:  
    `(a + b*c) - (d / e^f)`
4. Convert the whole thing to prefix:
    - left part: `+ a * b c`
    - right part: `/ d ^ e f`
    - main operator: `-`
So the final prefix is:
`- + a * b c / d ^ e f`
# Using Stack:
## Infix to prefix (using stack) for: `f^e/d-c*b+a`:
- **Given Infix:** `f ^ e / d - c * b + a`
- **Reverse the expression:** `a + b * c - d / e ^ f`
- ### Precedence:
	- `^ > * / > + -`  
	- `^` is **right associative**, others **left associative**.

| Symbol | Stack | Output   |
| ------ | ----- | -------- |
| a      |       | a        |
| +      | +     | a        |
| b      | +     | ab       |
| *      | + *   | ab       |
| c      | + *   | abc      |
| -      | -     | abc*+    |
| d      | -     | abc*+d   |
| /      | - /   | abc*+d   |
| e      | - /   | abc*+de  |
| ^      | - / ^ | abc*+de  |
| f      | - / ^ | abc*+def |

**Pop remaining stack:**
- Pop `^`, `/`, `-`
- Postfix: `abc*+def^/-`
- **Reverse postfix → PREFIX:**
- `- / ^ f e d + * c b a`
