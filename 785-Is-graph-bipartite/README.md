🧮 Check if Graph is Bipartite
This project contains a solution to determine whether an undirected graph is bipartite.

🧩 Problem Description
You are given an undirected graph with n nodes labeled from 0 to n - 1. The graph is represented as an adjacency list — a 2D array graph, where graph[u] contains all nodes adjacent to node u.

🔧 Graph Properties
No self-edges: graph[u] does not contain u.

No parallel edges: graph[u] contains unique values.

Undirected graph: If v is in graph[u], then u is in graph[v].

The graph may not be connected, i.e., there might be nodes u and v with no path between them.

🎯 Goal
Determine whether the given graph is bipartite.

A graph is bipartite if the nodes can be divided into two disjoint sets A and B such that every edge connects a node from set A to a node from set B (i.e., no two nodes within the same set are connected).

📥 Input Format
graph.length == n

1 <= n <= 100

0 <= graph[u].length < n

0 <= graph[u][i] <= n - 1

graph[u] contains unique values and no self-loops

If graph[u] contains v, then graph[v] contains u

✅ Example 1
Input:

javascript
Copy
Edit
graph = [[1,2,3], [0,2], [0,1,3], [0,2]]
Output:

arduino
Copy
Edit
false
Explanation:
There is no way to partition the nodes such that every edge connects a node in one set to a node in the other.

✅ Example 2
Input:

javascript
Copy
Edit
graph = [[1,3], [0,2], [1,3], [0,2]]
Output:

arduino
Copy
Edit
true
Explanation:
A valid partition is:

Set A = {0, 2}

Set B = {1, 3}

Every edge connects a node from Set A to Set B.

💡 Approach
This problem can be solved using Breadth-First Search (BFS) or Depth-First Search (DFS) with a coloring technique:

Initialize all nodes with color -1 (unvisited).

Traverse each component.

Assign color 0 to the starting node.

For every neighbor, assign the opposite color.

If a conflict is found (neighbor has the same color), the graph is not bipartite.

🚀 Time & Space Complexity
Time Complexity: O(V + E), where V = number of vertices and E = number of edges

Space Complexity: O(V) for visited/color tracking

