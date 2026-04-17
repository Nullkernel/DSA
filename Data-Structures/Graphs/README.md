# Graphs:
## What is a graph?
***A **graph** is an abstract data type (ADT) that models a set of objects and the relationships (links) between them.***
- The objects are called **vertices** (or nodes).
- The links between vertices are called **edges**.  
    Formally, a graph is a pair **`G=(V,E)`**, where **`V`** is a set of vertices and **`E`** is a set of edges (each edge connects a pair of vertices).
## Key terms:
- **Adjacency:** Two vertices are _adjacent_ if there is an edge directly connecting them.
- **Path:** A _path_ is a sequence of vertices connected by edges; it represents a route from one vertex to another.
- **Degree:** The degree of a vertex is the number of edges incident on it (for directed graphs there are indegree and outdegree).
## Common ways to represent graphs:
- **Adjacency matrix**:
    - A **`V×V`** matrix (where **`V`** is number of vertices).
    - Entry `[i][j]` is `1` (or `true`) if there is an edge from vertex `i` to `j`; otherwise `0` (or `false`).
    - Pros: `O(1)` edge-existence checks. Cons: `O(V^2)` memory - expensive for sparse graphs.
- **Adjacency list**:
    - For each vertex, store a list of its adjacent vertices.
    - Pros: **`O(V+E)`** memory and efficient to iterate neighbors - good for sparse graphs.
    - Cons: Checking existence of a specific edge may be slower than with a matrix.
