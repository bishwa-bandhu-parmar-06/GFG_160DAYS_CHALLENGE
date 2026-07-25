# Max Sum Square Sub-Matrix of Size k
# Difficulty: MediumAccuracy: 50.41%Submissions: 16K+Points: 4
# Given a n × n grid mat[][] of integers where values can be negative, find the maximum sum among all possible k × k sub-grids.

# Examples:

# Input: k = 3, mat[][] = [[1, 2, -1, 4], [-8, -3, 4, 2], [3, 8, 10, -8], [-4, -1, 1, 7]]
# Output: 20
# Explanation: The 3 × 3 sub-grid [[-3, 4, 2], [8, 10, -8], [-1, 1, 7]] highlighted in red has the maximum sum of 20. 








# Input: k = 1, mat[][] = [[4]]
# Output: 4
# Explanation: Only one 1×1 sub-grid exists with sum 4.

# Constraints:

# 1 ≤ n ≤ 1000
# 1 ≤ k ≤ n
# -1000 ≤ mat[i][j] ≤ 1000



class Solution:
    def maximumSum(self, mat, k):
        n=len(mat)
        for y in range(n):
            for x in range(n):
                mat[y][x]+=mat[y][x-1] if x-1>=0 else 0
        for y in range(n):
            for x in range(n):
                mat[y][x]+=mat[y-1][x] if y-1>=0 else 0
        mx=-float('inf')
        for y in range(k-1,n):
            for x in range(k-1,n):
                tmp=mat[y][x]
                tmp-=mat[y-k][x] if y-k>=0 else 0
                tmp-=mat[y][x-k] if x-k>=0 else 0
                tmp+=mat[y-k][x-k] if y-k>=0 and x-k>=0 else 0
                mx=max(mx,tmp)
        return mx

