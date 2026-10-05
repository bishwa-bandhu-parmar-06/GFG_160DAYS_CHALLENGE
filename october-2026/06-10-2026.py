# Longest Increasing Path in Matrix
# Difficulty: HardAccuracy: 44.5%Submissions: 18K+Points: 8
# Given a matrix with n rows and m columns. Your task is to find the length of the longest path in with the following constraints

# The values in path strictly increasing.  For example if a path of length k has values a1, a2, a3, .... ak  , then for every i from [2, k] this condition must hold ai > ai-1. 
# No cell should be revisited in the path.
# From each cell,  you can move in any of of the four directions: left, right, up, or down.
# You are not allowed to move diagonally or move outside the boundary.
# Examples:

# Input: n = 3, m = 3, matrix[][] = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
# Output: 5
# Explanation: One such path is 1 -> 2 -> 3 -> 6 -> 9, where each number is strictly greater than the previous.

# Input: n = 3, m = 3, matrix[][] = [[3, 4, 5], [6, 2, 6], [2, 2, 1]]
# Output: 4
# Explanation: One of the longest increasing paths is 3 -> 4 -> 5 -> 6.

# Constraints:

# 1 ≤ n, m ≤ 1000
# 0 ≤ matrix[i][j] ≤ 230



class Solution:
    def longIncPath(self, matrix, n, m):
        # code here
        dist = [[-1]*m for _ in range(n)]

        def dfs(r, c):
            nonlocal dist, m, n
            if dist[r][c] != -1:
                return dist[r][c]

            d = 1
            for r0, c0 in [(r+1, c), (r-1, c), (r, c+1), (r, c-1)]:
                if r0 < 0 or r0 >= n or c0 < 0 or c0 >= m:
                    continue
                if matrix[r0][c0] > matrix[r][c]:
                    d = max(d, dfs(r0, c0)+1)
            dist[r][c] = d
            return d

        ans = 0
        for r in range(n):
            for c in range(m):
                if dist[r][c] == -1:
                    ans = max(ans, dfs(r, c))
        return ans