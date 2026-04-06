# 1) Balanced Brackets Code:
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
# 2) Infix to Postfix:
## Meaning;
- **Infix**: operator is between operands  
    Example: `A+B*C`.
- **Postfix**: operator comes after operands  
    Example: `ABC*+`.
## Why postfix is useful?
- No need for parentheses.
- Easy evaluation using stack.
- Used in compilers and expression calculators.
## Operator precedence:
Higher precedence first:
1. `^`.
2. `*`, `/`.
3. `+`, `-`.
## Associativity:
- `^` → right associative.
- `*`, `/`, `+`, `-` → left associative.
## Rules for conversion:
1. Operand → output directly.
2. `(` → push to stack.
3. `)` → pop until `(` is found.
4. Operator → pop operators from stack while:
    - top has higher precedence, (or)
    - top has equal precedence and operator is left associative.
        Then push current operator.
5. At the end, pop all remaining operators.
## Example:
Convert: `A+B*C`.
Steps:
- `A` → output: `A`.
- `+` → push `+`.
- `B` → output: `AB`.
- `*` → higher precedence than `+`, push `*`.
- `C` → output: `ABC`.
- Pop stack → `*` then `+`.
Final postfix: `ABC*+`.
## Time and Space Complexity:
- Time: `O(n)`.
- Space: `O(n)`.
## Pseudocode:
```bash
infixToPostfix(expr):
    create empty stack
    for each symbol x in expr:
        if x is operand:
            append x to output
        else if x == '(':
            push x
        else if x == ')':
            while top != '(':
                append pop() to output
            pop '('
        else if x is operator:
            while stack not empty and precedence(top) >= precedence(x):
                append pop() to output
            push x
    while stack not empty:
        append pop() to output
```
# 3) Revised Stack:
## Definition:
A **stack** is a linear data structure that follows **LIFO**:  
**Last In, First Out**.
## Main operations:
- `push()` → insert element at top.
- `pop()` → remove top element.
- `peek()` / `top()` → view top element.
- `isEmpty()`.
- `isFull()` for array implementation.
## Real-life example:
A pile of plates:
- Add plate on top.
- Remove plate from top.
## Applications:
- Balanced brackets.
- Infix to postfix/prefix.
- Function calls / recursion.
- Undo operation.
- Backtracking.
- Expression evaluation.
## Stack using array:
### Pros:
- Simple.
- Fast access.
### Cons:
- Fixed size.
- Overflow possible.
### Conditions:
- **Overflow**: stack is full.
- **Underflow**: stack is empty and pop is attempted.
## Stack using linked list:
### Pros:
- Dynamic size.
- No fixed limit unless memory ends.
### Cons:
- Slightly more memory due to pointers.
## Basic stack operations:
### Push:
Insert at top.
### Pop:
Delete from top.
### Peek:
Read top without removing.
## Complexity:
- Push: `O(1)`.
- Pop: `O(1)`.
- Peek: `O(1)`.
## Array stack structure:
```bash
top = -1

push(x):
    if top == max-1:
        overflow
    else:
        top = top + 1
        stack[top] = x

pop():
    if top == -1:
        underflow
    else:
        x = stack[top]
        top = top - 1
        return x
```
# 4) Revised Linked List:
## Definition:
A **linked list** is a dynamic linear data structure made of nodes.
Each node contains:
- **Data**.
- **Link/Pointer** to the next node.
## Types of linked list:
1. **Singly linked list**:
    - Each node points to the next node only.
2. **Doubly linked list**:
    - Each node points to previous and next node.
3. **Circular linked list**:
    - Last node points back to first node.
## Singly linked list structure:
`[data | next] -> [data | next] -> [data | next] -> NULL`.
## Advantages:
- Dynamic size.
- Easy insertion and deletion.
- No need for contiguous memory.
## Disadvantages:
- Extra memory for pointers.
- No direct random access.
- Traversal is slower than arrays.
## Basic operations:
- Insert at beginning.
- Insert at end.
- Insert after a node.
- Delete from beginning.
- Delete from end.
- Search.
- Traverse.
## Example:
List: `10 -> 20 -> 30 -> NULL`.
Traversal:
- Start from head.
- Visit each node until `NULL`.
## Complexity:
For singly linked list:
- Insert at beginning: `O(1)`.
- Insert at end: `O(n)` without tail, `O(1)` with tail.
- Delete at beginning: `O(1)`.
- Search: `O(n)`.
- Traverse: `O(n)`.
## Node representation:
```bash
node {
    data
    next
}
```
## Head pointer:
- `head` points to first node.
- If `head == NULL`, list is empty.
## Insertion at beginning:
```bash
newNode->next = head
head = newNode
```
# Deletion at beginning:
```bash
temp = head
head = head->next
free(temp)
```
