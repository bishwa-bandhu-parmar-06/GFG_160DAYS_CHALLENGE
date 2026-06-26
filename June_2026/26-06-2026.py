# Count Matching Subsequences
# Difficulty: MediumAccuracy: 57.65%Submissions: 52K+Points: 4
# Given two strings, s1 and s2, count the number of subsequences of string s1 equal to string s2.

# Return the total count modulo 1e9+7.

# Examples :

# Input: s1 = "geeksforgeeks", s2 = "gks"
# Output: 4
# Explanation: We can pick characters from s1 as a subsequence from indices [0, 3, 4], [0, 3, 12], [0, 11, 12] and [8, 11, 12]. So total 4 subsequences of s1 that are equal to s2.
# Input: s1 = "problemoftheday", s2 = "geek"
# Output: 0
# Explanation: No subsequence of string s1 is equal to string s2.
# Constraints:
# 1 ≤ s1.size(), s2.size() ≤ 103


class Solution:
    def countWays(self, s, t):
        n, m = len(s), len(t)
        MOD = 10**9+7
        
        dp = [[0]*(m+1) for _ in range(n+1)]
        for i in range(n+1):
            dp[i][0] = 1
            
        for i in range(n+1):
            for j in range(1, min(i, m)+1):
                not_take = dp[i-1][j]
                take = 0
                if s[i-1] == t[j-1]:
                    take = dp[i-1][j-1]
                dp[i][j] = (take+not_take)%MOD
        return dp[n][m]