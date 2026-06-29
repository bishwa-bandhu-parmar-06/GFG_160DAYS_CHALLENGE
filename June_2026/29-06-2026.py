# Max Dot Product with 0 Insertions
# Difficulty: MediumAccuracy: 13.27%Submissions: 66K+Points: 4
# Given two arrays a[] and b[] of positive integers of size n and m respectively, where m ≤ n.  You are allowed to insert zeros anywhere into the second array b so that its length becomes equal to n.

# The dot product of two arrays of equal length n is defined as: a[0]*b[0] + a[1]*b[1] + ... + a[n-1]*b[n-1].
# Return the maximum possible dot product of the two arrays.


class Solution:
    def maxDotProduct(self, a, b):
        # code here
        
        dp = [[-1 for i in range(len(b))] for i in range(len(a))]

        def solve(i, j):
            if j == -1:
                return 0
            if i == -1:
                return -10**18
            
            if dp[i][j] != -1: return dp[i][j]
            
            take = (a[i] * b[j]) + solve(i-1, j-1)
            
            skip = solve(i-1, j)
            
            dp[i][j] = max(take,skip)
            
            return dp[i][j]
            
        return solve(len(a) - 1, len(b) - 1)