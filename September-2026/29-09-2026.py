# Min Steps by Knight
# Difficulty: MediumAccuracy: 37.32%Submissions: 140K+Points: 4Average Time: 20m
# Given a square chessboard of size n × n, the initial position knightPos and target position targetPos of a Knight are given. Find the minimum number of moves required for the Knight to reach targetPos.

# A Knight moves in an L-shape, covering 2 cells in one direction and 1 cell perpendicular to it. From (x, y), it can move to: (x ± 2, y ± 1) and (x ± 1, y ± 2)

# This gives at most 8 possible moves:


# Note: The positions are given using 1-based indexing.

# Examples:

# Input: n = 3, knightPos[] = [3, 3], targetPos[]= [1, 2]
# Output: 1
# Explanation: Knight takes 1 step to reach from (3, 3) to (1 ,2).
# Input: n = 6, knightPos[] = [1, 3], targetPos[] = [5, 1]
# Output: 2
# Explanation: In above diagram Knight takes 2 step to reach from (1, 3) to (5, 0): (1, 3) -> (3, 2) -> (5, 1)  
 
# Constraints:

# n ≤ 1000
# 2 ≤ knightPos.size(), targetPos.size() ≤ 2
# 1 ≤ knightPos[i], targetPos[i] ≤ n



class Solution:
	def minStepToReachTarget(self, knightPos: list[int], targetPos: list[int], n: int) -> int:
		from collections import deque
        if targetPos == knightPos:
        	return 0
        
        vis = [[False] * (n + 1) for _ in range(n + 1)]
        
        dx = [1, 1, 2, 2, -1, -1, -2, -2]
        dy = [2, -2, 1, -1, 2, -2, 1, -1]
        
        q = deque([(knightPos[0], knightPos[1])])
        vis[knightPos[0]][knightPos[1]] = True
        
        level = 0
        
        while q:
        	size = len(q)
        	level += 1
        
        	for _ in range(size):
        		x, y = q.popleft()
        
        		for i in range(8):
        			nx = x + dx[i]
        			ny = y + dy[i]
        
        			if 1 <= nx <= n and 1 <= ny <= n and not vis[nx][ny]:
        				if [nx, ny] == targetPos:
        					return level
        
        				vis[nx][ny] = True
        				q.append((nx, ny))
        
        return -1