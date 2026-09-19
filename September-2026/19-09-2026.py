# Min Cost To Make Two Strings Identical
# Difficulty: MediumAccuracy: 52.29%Submissions: 35K+Points: 4
# Given two strings s1 and s2, and two integers costS1 and costS2, where costS1 is the cost of deleting one character from s1 and costS2 is the cost of deleting one character from s2, find the minimum cost required to make the two strings identical.

# You can delete any number of characters from either string, but the order of the remaining characters must be preserved.

# Examples:

# Input: s1 = "abcd", s2 = "acdb", costS1 = 10, costS2 = 20
# Output: 30
# Explanation: Delete 'b' from both strings to obtain "acd". The total cost is 10 + 20 = 30.
# Input: s1 = "ef", s2 = "gh", costS1 = 10, costS2 = 20
# Output: 60
# Explanation: The two strings have no common characters, so delete all characters from both strings. The total cost is (2 × 10) + (2 × 20) = 60.
# Constraints:

# 1 ≤ s1.size(), s2.size() ≤ 1000
# 1 ≤ costS1, costS2 ≤ 105

class Solution:
    def findMinCost(self, s1: str, s2: str, costS1: int, costS2: int) -> int:
            m, n = len(s1), len(s2)
            dp = [[0] * (n + 1) for _ in range(m + 1)]
            for i in range(m + 1):
                dp[i][0] = i * costS1
            for j in range(n + 1):
                dp[0][j] = j * costS2
            for i in range(m):
                for j in range(n):
                    if s1[i] == s2[j]:
                        dp[i + 1][j + 1] = dp[i][j]
                    else:
                        dp[i + 1][j + 1] = min(
                            costS2 + dp[i + 1][j],
                            costS1 + dp[i][j + 1]
                        )
            return dp[m][n]