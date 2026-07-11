
# Longest Possible Route in a Matrix with Hurdles
# Difficulty: MediumAccuracy: 50.0%Submissions: 18K+Points: 4Average Time: 15m
# Given a binary matrix mat[][] of size n × m containing values 0 and 1, and four integers xs, ys, xd, and yd representing the source cell (xs, ys) and destination cell (xd, yd), find the length of the longest possible path from the source cell to the destination cell. From any cell, you can move to its adjacent cells in the up, down, left, and right directions.

# 1 represents a traversable cell.
# 0 represents a blocked cell that cannot be visited.
# A cell can be visited at most once in a path.
# If the destination cannot be reached from the source, return -1.




class Solution:
    def longestPath(self, mat, xs, ys, xd, yd):
        if mat[xs][ys]==0 or mat[xd][yd]==0: return -1
        n,m=len(mat),len(mat[0])
        ans=-1

        def dfs(x,y,d):
            nonlocal ans
            if (x,y)==(xd,yd):
                ans=max(ans,d)
                return
            mat[x][y]=0
            for dx,dy in ((1,0),(-1,0),(0,1),(0,-1)):
                nx,ny=x+dx,y+dy
                if 0<=nx<n and 0<=ny<m and mat[nx][ny]:
                    dfs(nx,ny,d+1)
            mat[x][y]=1

        dfs(xs,ys,0)
        return ans