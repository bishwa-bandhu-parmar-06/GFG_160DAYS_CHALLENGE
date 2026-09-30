# Ways to Reach Origin
# Difficulty: MediumAccuracy: 53.93%Submissions: 57K+Points: 4Average Time: 15m
# Geek is standing at a point (x, y) on a 2D grid and wants to reach the origin (0, 0).

# From any point, Geek can move in only two directions: left, from (x, y) to (x - 1, y), or down, from (x, y) to (x, y - 1).

# Find the total number of distinct paths for Geek to reach (0, 0) from (x, y). Since the answer can be very large, return it modulo 109+7.

# Examples:

# Input: x = 3, y = 0
# Output: 1
# Explanation: The only possible path is (3, 0) -> (2, 0) -> (1, 0) -> (0, 0), since y = 0, there is no option to move down at any step.
# Input: x = 3, y = 6
# Output: 84
# Explanation: There are a total of 84 distinct paths from (3, 6) to (0, 0) using only left and down moves.
# Constraints:

# 0 ≤ x, y ≤ 500



class Solution:
    def ways(self, x: int, y: int) -> int:
            MODULO = 10**9 + 7
            dp = [[0] * (y + 2) for _ in range(x + 2)]
            dp[x][y + 1] = 1
            for i in range(x, -1, -1):
                for j in range(y, -1, -1):
                    dp[i][j] = (dp[i + 1][j] + dp[i][j + 1]) % MODULO
            return dp[0][0]