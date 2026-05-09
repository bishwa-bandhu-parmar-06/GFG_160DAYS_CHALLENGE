# // Count Spanning Trees in a Graph
# // Difficulty: HardAccuracy: 72.41%Submissions: 6K+Points: 8
# // Given a connected undirected graph with n vertices and m edges, where each edge is represented as edges[i]=[u,v]  indicating an edge between vertices u and v.

# // Determine the total number of distinct spanning trees that can be formed from the graph.

# // Note: A spanning tree is a subgraph of the given graph that includes all n vertices, has exactly n-1 edges, is connected, and contains no cycles; therefore, every connected undirected graph always has at least one spanning tree.

# // Examples:

# // Input: n = 6, edges = [[0, 3], [0, 1], [1, 2], [1, 5], [3, 4]]
# // Output: 1
# // Explanation: The graph has 6 vertices and 5 edges, and it is connected, so it is already a tree (m = n-1). A tree has only one spanning tree, which is the graph itself, so the answer is 1.
  
# // Input: n = 3, edges = [[0, 1], [0, 2], [1, 2]]
# // Output: 3
# // Explanation: There are exactly 3 possible spanning trees for the given graph. 
 
# // Input: n = 1, edges = []
# // Output: 1
# // Explanation: With 1 vertex, a spanning tree needs 0 edges. The graph already satisfies this, so the answer is 1.


import numpy as np

class Solution:
    def countSpanTree(self, n, edges):
        L = np.zeros((n, n), dtype=int)
        for u, v in edges:
            L[u][u] += 1
            L[v][v] += 1
            L[u][v] -= 1
            L[v][u] -= 1
        minor = L[:-1, :-1]
        return round(np.linalg.det(minor))