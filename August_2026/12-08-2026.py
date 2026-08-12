# Adventure in a Maze
# Difficulty: HardAccuracy: 39.96%Submissions: 13K+Points: 8Average Time: 30m
# Given a maze represented as an n x n grid, grid[][], using 0-based indexing. Each cell contains one of the values 1, 2, or 3, which determines the direction(s) you are allowed to move from that cell:

# 1 - you may move Right only.
# 2 - you may move Down only.
# 3 - you may move Right or Down (both directions are available).
# You start at the top-left cell (0, 0) (the Entry) and must reach the bottom-right cell (n-1, n-1) (the Exit), following the movement rule of each cell you pass through. You are never allowed to move outside the boundaries of the grid.

# The Adventure of a path is the sum of the values of all cells visited along that path (including both the entry and exit cells).

# Find the total number of distinct valid paths from Entry to Exit, and among all such paths, the maximum possible Adventure. Return the answer as [totalPaths, maxAdventure].

# Note: Return totalPaths modulo 109 + 7, maxAdventure needs no modulo, as it stays small regardless of grid size.

# Examples:

# Input: grid[][] = [[3, 2], [1, 3]]
# Output: [2, 8]
# Explanation:
# There are 2 valid paths from [0, 0] to [1, 1]:
# Path 1: [0, 0] -> [0, 1] -> [1, 1], values 3 + 2 + 3 = 8
# Path 2: [0,0] -> [1, 0] -> [1, 1], values 3 + 1 + 3 = 7
# The maximum Adventure among these is 8, so the output is [2, 8].
# Input: grid[][] = [[1, 1, 3, 2, 1], [3, 2, 2, 1, 2], [1, 3, 3, 1, 3], [1, 2, 3, 1, 2], [1, 1, 1, 3, 1]]
# Output: [4, 18]
# Explanation: There are 4 valid paths from Entry to Exit, with total Adventures 
# 18, 17, 17, and 16 respectively. The maximum among these is 18, so the output is [4, 18].
# Constraints:
# 1 ≤ n ≤ 100


MOD = 1000000007

RIGHT = 1
DOWN = 2


class Solution:
    def findWays(self, maze):
        n = len(maze)

        adv = [[0] * n for _ in range(n)]
        paths = [[0] * n for _ in range(n)]

        # Starting cell
        adv[0][0] = maze[0][0]
        paths[0][0] = 1

        # First row
        for j in range(1, n):
            if maze[0][j - 1] == DOWN:
                break

            adv[0][j] = adv[0][j - 1] + maze[0][j]
            paths[0][j] = 1

        # First column
        for i in range(1, n):
            if maze[i - 1][0] == RIGHT:
                break

            adv[i][0] = adv[i - 1][0] + maze[i][0]
            paths[i][0] = 1

        # Remaining cells
        for i in range(1, n):
            for j in range(1, n):

                # Come from above
                if paths[i - 1][j] and maze[i - 1][j] != RIGHT:
                    adv[i][j] = adv[i - 1][j] + maze[i][j]
                    paths[i][j] = paths[i - 1][j]

                # Come from left
                if paths[i][j - 1] and maze[i][j - 1] != DOWN:

                    paths[i][j] += paths[i][j - 1]
                    paths[i][j] %= MOD

                    adv[i][j] = max(
                        adv[i][j],
                        adv[i][j - 1] + maze[i][j]
                    )

        return [paths[n - 1][n - 1], adv[n - 1][n - 1]]