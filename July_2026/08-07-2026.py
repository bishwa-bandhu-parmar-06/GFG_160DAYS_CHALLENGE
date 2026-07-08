# Towers Reaching Both Stations
# Difficulty: MediumAccuracy: 60.27%Submissions: 18K+Points: 4
# Given a matrix mat[][] of size n x m, where mat[i][j] represents the signal strength of a communication tower. Two control stations monitor the network:

# Station P covers the top and left boundaries of the grid.
# Station Q covers the bottom and right boundaries of the grid.
# A signal can propagate from a tower to one of its neighbouring towers in the four directions (North, South, East, and West) only if the neighbouring tower has a signal strength less than or equal to that of the current tower.

# Determine the number of towers (x, y) from which a signal can eventually reach both Station P and Station Q. Any tower located on a boundary covered by a station can transmit directly to that station.

# Examples:

# Input: mat[][] = [[1, 2, 2, 3, 5], [3, 2, 3, 4, 4], [2, 4, 5, 3, 1], [6, 7, 1, 4, 5], [5, 1, 1, 2, 4]]
# Output: 7
# Explanation: 

# (0, 4) & (4, 0) are part of both P & Q 
# (1, 3) reaches P using (1,3)->(0,3) and Q using (1,3)->(1,4)
# (1, 4) reaches P using (1,4)->(1,3)->(1,2)->(0,2) and it is on Q
# (2, 2) reaches P using (2,2)->(2,1)->(2,0) and Q using (2,2)->(2,3)->(2,4)
# (3, 0) is on P and reaches Q using (3,0)->(4,0)
# (3, 1) reaches P using (3,1)->(3,0) and Q using (3,1)->(4,1)
# Input: mat[][] = [[2, 2], [2, 2]]
# Output: 4
# Explanation: In the following example, all cells allow signals to propagate to both the stations.
# Constraints:
# 1 ≤ n, m ≤ 103
# 1 ≤ mat[i][j] ≤ 103 


from collections import deque

class Solution:
    def countCoordinates(self, mat):
        n = len(mat)
        m = len(mat[0])

        def bfs(starts):
            vis = [[False] * m for _ in range(n)]
            q = deque()

            for r, c in starts:
                if not vis[r][c]:
                    vis[r][c] = True
                    q.append((r, c))

            dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]

            while q:
                x, y = q.popleft()

                for dx, dy in dirs:
                    nx, ny = x + dx, y + dy

                    if (0 <= nx < n and 0 <= ny < m and
                        not vis[nx][ny] and
                        mat[nx][ny] >= mat[x][y]):
                        vis[nx][ny] = True
                        q.append((nx, ny))

            return vis

        # Station P: top row + left column
        p_starts = [(0, j) for j in range(m)] + [(i, 0) for i in range(n)]

        # Station Q: bottom row + right column
        q_starts = [(n - 1, j) for j in range(m)] + [(i, m - 1) for i in range(n)]

        p = bfs(p_starts)
        q = bfs(q_starts)

        ans = 0
        for i in range(n):
            for j in range(m):
                if p[i][j] and q[i][j]:
                    ans += 1

        return ans