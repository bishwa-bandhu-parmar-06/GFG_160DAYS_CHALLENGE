# Count Tree Paths With Limited Max Edge Weight
# Difficulty: HardAccuracy: 71.75%Submissions: 28K+Points: 8
# Given a weighted tree with n nodes, numbered from 1 to n and n - 1 edges, where each edge is represented as [u, v, w] indicating an edge between nodes u and v with weight w.

# You are also given an array queries[], where each queries[i] represents a maximum allowed edge weight.

# For each query x, find the number of distinct paths in the tree such that the maximum edge weight along the path is less than or equal to x.

# Return an array containing the number of valid paths for each query.

# Note:

# A path from node u to node v and the path from node v to node u are considered the same path.
# A path must contain at least one edge. A path from a node to itself is not considered.
# Examples:

# Input: n = 3, edges[][] = [[1, 2, 1], [2, 3, 4]], queries[] = [3]
# Output: [1]
# Explanation:
# For x = 3, only the edge [1, 2, 1] has weight less than or equal to 3.
# Therefore, the only valid path is: 1 -> 2
# The path 1 -> 3 contains an edge of weight 4, so it is not valid.
# Hence, the answer is 1.
# Input: n = 7, edges[][] = [[1, 2, 3], [2, 3, 1], [2, 4, 9], [3, 6, 7], [3, 5, 8], [5, 7, 4]], queries[] = [1, 3, 5]
# Output: [1, 3, 4]
# Explanation: For x = 1, only the edge [2, 3, 1] satisfies the condition. 
# Therefore, the only valid path is 2 -> 3, giving an answer of 1.
# For x = 3, the edges [2, 3, 1] and [1, 2, 3] can be used. 
# They form three valid paths: 1 -> 2, 2 -> 3, and 1 -> 3. 
# For x = 5, the edges with weights 1, 3, and 4 can be used. 
# They form four valid paths: 1 -> 2, 2 -> 3, 1 -> 3, and 5 -> 7.
# Constraints:

# 2 ≤ n ≤ 104
# 1 ≤ queries.size() ≤ 104
# 0 ≤ queries[i] ≤ 105
# edges.size() = n-1
# edges[i].size() = 3
# 1 ≤ edges[i][0], edges[i][1] ≤ n
# edges[i][0] != edges[i][1]
# 0 ≤ edges[i][2] ≤ 105


class Solution:
    def maximumWeight(self, n, edges, queries):
        from operator import itemgetter
        parent = list(range(n + 1))
        size = [1] * (n + 1)
        size[0] = 0
        
        def find(u: int) -> int:
            if parent[u] != u:
                parent[u] = find(parent[u])
            return parent[u]
        
        edges.sort(key=itemgetter(2))
        q_order = sorted(range(len(queries)), key=queries.__getitem__)
        answers = [0] * len(queries)
        e_i = count = 0
        for q_i in q_order:
            w = queries[q_i]
            while e_i < n - 1 and edges[e_i][2] <= w:
                u, v, _ = edges[e_i]
                u, v = find(u), find(v)
                if u != v:
                    count += size[u] * size[v]
                    size[u] += size[v]
                    parent[v] = u
                e_i += 1
            answers[q_i] = count
        return answers