# Geek in a Maze
# Difficulty: HardAccuracy: 49.51%Submissions: 12K+Points: 8
# Given a maze mat[][] of size n × m, where each cell is either:

# '.' representing an empty cell, or
# '#' representing an obstacle.
# Find the number of distinct empty cells that Geek can visit starting from the cell (r, c).

# Geek can move up, down, left, or right to an adjacent non-obstacle cell inside the maze.
# On any path, Geek can make at most u upward moves and d downward moves.
# There is no limit on the number of left or right moves.
# If the starting cell is an obstacle, return 0.
# Note :  There can be multiple paths starting from [r, c].

# Examples:

# Input: r = 1, c = 0, u = 1, d = 1, mat = [['.', '.', '.'], ['.', '#', '.'], ['#', '.', '.']]
# Output: 5
# Explanation: Geek starts from (1, 0) and follows the path (1,0)->(0,0)->(0,1)->(0,2)->(1,2). The cells (1,1) and (2,0) are obstacles, so they cannot be visited. Hence, Geek can visit 5 distinct empty cells.
 
# Input: r = 2, c = 1, u = 2, d = 2, mat = [['.', '.', '.'], ['.', '#', '.'], ['.', '.', '.']]
# Output: 8
# Explanation: Geek starts from (2, 1) and follows the path (2,1)->(2,2)->(1,2)->(0,2)->(0,1)->(0,0)->(1,0)->(2,0). The cell (1,1) is an obstacle, so it cannot be visited. Hence, Geek can visit all 8 empty cells.

# Input: r = 2, c = 1, u = 1, d = 0, mat = [['.', '.', '.'], ['.', '#', '.'], ['.', '.', '.']]
# Output: 5
# Explanation: The paths followed are (2, 1)->(2, 0)->(1, 0) and (2, 1)->(2, 2)->(1, 2)
# Constraints:

# 1 ≤ n, m ≤ 106
# 0 ≤ r, c < 106
# 0 ≤ u, d ≤ 106


from collections import deque

class Solution:

    def numberOfCells(self, r, c, u, d, mat):

        n = len(mat)
        m = len(mat[0])

        if mat[r][c] == '#':
            return 0

        INF = 10**9

        # dist[x][y] = minimum number of DOWN moves
        # required to reach (x, y)
        dist = [[INF] * m for _ in range(n)]

        dist[r][c] = 0

        # 0-1 BFS
        q = deque()
        q.append((r, c))

        while q:

            x, y = q.popleft()

            # Left
            if y - 1 >= 0 and mat[x][y - 1] == '.':
                if dist[x][y] < dist[x][y - 1]:
                    dist[x][y - 1] = dist[x][y]
                    q.appendleft((x, y - 1))

            # Right
            if y + 1 < m and mat[x][y + 1] == '.':
                if dist[x][y] < dist[x][y + 1]:
                    dist[x][y + 1] = dist[x][y]
                    q.appendleft((x, y + 1))

            # Up
            if x - 1 >= 0 and mat[x - 1][y] == '.':
                if dist[x][y] < dist[x - 1][y]:
                    dist[x - 1][y] = dist[x][y]
                    q.appendleft((x - 1, y))

            # Down
            if x + 1 < n and mat[x + 1][y] == '.':
                if dist[x][y] + 1 < dist[x + 1][y]:
                    dist[x + 1][y] = dist[x][y] + 1
                    q.append((x + 1, y))

        count = 0

        for x in range(n):
            for y in range(m):

                if mat[x][y] == '#':
                    continue

                down_used = dist[x][y]

                if down_used == INF:
                    continue

                # From:
                # x = r + down_used - up_used
                #
                # therefore:
                # up_used = down_used - (x - r)

                up_used = down_used - (x - r)

                if down_used <= d and up_used <= u:
                    count += 1

        return count