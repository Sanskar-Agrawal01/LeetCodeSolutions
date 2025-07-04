📡 743. Network Delay Time
Difficulty: Medium
Topics: Graphs, Dijkstra’s Algorithm, Shortest Path
Companies: [Available in LeetCode Premium]

🧠 Problem Statement
You are given a network of n nodes, labeled from 1 to n. You are also given a list of directed edges times, where each entry times[i] = (ui, vi, wi) represents a travel time of wi from node ui to node vi.

We will send a signal from a starting node k. Your task is to determine the minimum time it takes for all n nodes to receive the signal.

If it is impossible for all nodes to receive the signal, return -1.

🧾 Input
times: List of directed edges, each represented as [ui, vi, wi]

n: Total number of nodes

k: Starting node

Constraints
1 <= k <= n <= 100

1 <= times.length <= 6000

times[i].length == 3

1 <= ui, vi <= n

ui != vi

0 <= wi <= 100

All pairs (ui, vi) are unique (no multiple edges)

✅ Output
Return the minimum time for all nodes to receive the signal, or -1 if it is not possible.

🔍 Examples
Example 1
lua
Copy
Edit
Input:
times = [[2,1,1],[2,3,1],[3,4,1]]
n = 4
k = 2

Output: 2
Explanation:
From node 2:

Node 1 receives in 1 unit

Node 3 receives in 1 unit

Node 4 receives in 2 units (via node 3)

Example 2
lua
Copy
Edit
Input:
times = [[1,2,1]]
n = 2
k = 1

Output: 1
Example 3
lua
Copy
Edit
Input:
times = [[1,2,1]]
n = 2
k = 2

Output: -1
Explanation:
Node 2 cannot reach node 1, hence not all nodes are reachable.

💡 Approach
This is a classic Single-Source Shortest Path problem, and can be solved efficiently using Dijkstra’s Algorithm with a priority queue (min-heap).
Alternative approaches like Bellman-Ford can work but are less optimal for this case due to higher time complexity.