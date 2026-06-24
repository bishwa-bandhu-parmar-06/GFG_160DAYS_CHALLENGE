# Rat Maze With Multiple Jumps
# Difficulty: MediumAccuracy: 38.46%Submissions: 21K+Points: 4
# Given a matrix mat[][] of size n × n, where mat[i][j] represents the maximum number of steps a rat can jump either forward (right) or downward from that cell, find a path for the rat to reach from the top-left cell (0, 0) to the bottom-right cell (n - 1, n - 1). A cell containing 0 is blocked and cannot be used in the path. It is guaranteed that the cell mat[n-1][n-1] is not 0.

# Return an n × n matrix where 1 represents the cells included in the path and 0 represents the remaining cells. If no valid path exists, return [[-1]].

# Note: If multiple valid paths exist, choose the path with the shortest possible jumps first. For the same jump length, moving forward (right) should be preferred over moving downward.

class Solution:
	def shortestDist(self, mat):
        n = len(mat)
        ans = [[0] * n for _ in range(n)]
        dp = [[-1] * n for _ in range(n)]  # -1 = unknown, 0 = impossible

        def dfs(i, j):
            if i >= n or j >= n:
                return False


            if i == n - 1 and j == n - 1:
                ans[i][j] = 1
                return True

            if mat[i][j] == 0:
                return False

            # Already know this cell cannot reach the end
            if dp[i][j] == 0:
                return False

            ans[i][j] = 1

            # Try smaller jumps first
            for jump in range(1, mat[i][j] + 1):
                # Right first
                if dfs(i, j + jump):
                    return True
                # Down second
                if dfs(i + jump, j):
                    return True

            ans[i][j] = 0
            dp[i][j] = 0  
            return False

        if dfs(0, 0):
            return ans
        return [[-1]]
		# code here
		