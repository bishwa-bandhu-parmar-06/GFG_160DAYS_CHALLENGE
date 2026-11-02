# Largest Sum Cycle
# Difficulty: HardAccuracy: 51.93%Submissions: 34K+Points: 8
# Given an array edge[] of size n, there are n cells numbered from 0 to n - 1. Each cell has at most one outgoing edge.

# For every cell i:

# edge[i] is the cell reached from i in one step.
# edge[i] = -1 means that cell i has no outgoing edge.
# A cycle is a sequence of cells where, by following the outgoing edges, we eventually return to the starting cell. The sum of a cycle is the sum of the indices of all cells in that cycle.

# Return the maximum cycle sum. If there is no cycle, return -1.

# Examples:

# Input: edge[] = [1, 2, 0, -1]
# Output: 3
# Explanation: There is only one cycle in the graph i.e. 0 -> 1 -> 2 -> 0. Sum of the cell index in that cycle = 0 + 1 + 2 = 3.

# Input: edge[] = [2, 0, -1, 2]
# Output: -1
# Explanation: There is no cycle in the graph. The edges are 1 -> 0 -> 2 <- 3. Hence, 2 has no outgoing edge, so no cycle exists.

# Constraints:

# 2 ≤ edge.size() ≤ 105
# -1 ≤ edge[i] < edge.size()
# edge[i] != i


class Solution:
    def largestSumCycle(self, edge):
        # code here
        
        ans = -1
        def dfs(v, path = {}, sum=0):
            nonlocal edge, ans
            if v == -1:
                return 
            
            sum += v
            if v in path:
                ans = max(ans, sum - path[v])
                return
            path[v] = sum
            dfs(edge[v], path, sum)
            edge[v] = -1
            path.pop(v)
        
        for i in edge:
            if edge[i] != -1:
                dfs(i)
        return ans