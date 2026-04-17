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
# Spanning Tree:
- It is a subset of an undirected graph that contains all the vertices of the graph connected with the minimum number of edges.
- Precisely, the edges of the spanning tree form a subset of the edges in the original graph.
- If all the vertices are connected in a graph, then there exists at least one spanning tree. In fact, in a connected graph, there may exist more than one spanning tree.
- **In other words:** A spanning tree is a subset of a graph `G`, which has all the vertices covered with minimum possible number of edges.
- **Example:**
```
		A         A          A         A
	   / \  =>   / \  (or)  /    (or)   \
	  C---B     C   B      C---B     C---B
```
### Applications of Spanning Tree:
- Civil Network Planning.
- Computer Network Routing Protocol.
- Cluster Analysis.
