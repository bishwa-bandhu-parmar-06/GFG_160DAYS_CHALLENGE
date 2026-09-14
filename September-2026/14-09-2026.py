# Shortest Safe Route in Grid
# Difficulty: MediumAccuracy: 50.58%Submissions: 45K+Points: 4
# Given a 2D matrix mat[][] of size n × m, where each cell is either 0 (landmine) or 1 (safe), find the minimum number of steps required to travel from any cell in the leftmost column to any cell in the rightmost column.

# You can move only in four directions: up, down, left, and right.
# A cell is unsafe if it contains a landmine or is directly adjacent (up, down, left, or right) to a landmine, and such cells must be avoided.
# Return -1 if no safe path exists.
# Examples:

# Input: mat[][] = [[1, 0, 1, 1, 1], [1, 1, 1, 1, 1], [1, 1, 1, 1, 1], [1, 1, 1, 0, 1], [1, 1, 1, 1, 0]]

# Output: 6
# Explanation: We can see that length of shortest safe route is 6. 

# Input: mat[][] = [[1, 1, 1, 1, 1], [1, 1, 0, 1, 1], [1, 1, 1, 1, 1]]

# Output: -1
# Explanation: There is no possible path from first column to last column.
# Constraints:

# 1 ≤ n, m ≤ 103
# 0 ≤ mat[i][j] ≤ 1


class Solution:
    def shortestPath(self, mat: list[list[int]]) -> int:
            from collections import deque
            DXDY = [(-1, 0), (0, 1), (1, 0), (0, -1)]
            m, n = len(mat), len(mat[0])
            # mark cells around landmines
            for x in range(m):
                for y in range(n):
                    if mat[x][y] == 0:
                        for dx, dy in DXDY:
                            x1, y1 = x + dx, y + dy
                            if 0 <= x1 < m and 0 <= y1 < n and mat[x1][y1] == 1:
                                mat[x1][y1] = 2
            # initialise the queue with safe first column's cells
            q = deque((x, 0) for x in range(m) if mat[x][0] == 1)
            if n == 1 and q:
                # the first column is the last column
                return 1
            for steps in range(2, m * n):
                for _ in range(len(q)):
                    x, y = q.popleft()
                    for dx, dy in DXDY:
                        x1, y1 = x + dx, y + dy
                        if 0 <= x1 < m and 0 <= y1 < n and mat[x1][y1] == 1:
                            if y1 == n - 1:
                                return steps
                            mat[x1][y1] = -1
                            q.append((x1, y1))
                if not q:
                    break
            return -1
        # code here
        