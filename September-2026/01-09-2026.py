# Count Palindromic Strings with Constraints
# Solved
# Difficulty: MediumAccuracy: 34.38%Submissions: 5K+Points: 4
# Given two integers n  and k, consider an alphabet consisting of the first k lowercase English letters. Find the number of palindromic strings whose length is less than or equal to n, such that:

# Every character in the string belongs to the given alphabet.
# No character appears more than twice in the string.
# Note: Since the answer can be very large, return it modulo 10^9+7.

# Examples:

# Input: n = 3, k = 2
# Output: 6
# Explanation: The possible strings are: "a", "b", "aa", "bb", "aba", "bab".
# Input: n = 4, k = 3
# Output: 18
# Explanation: The possible strings are:"a", "b", "c", "aa", "bb", "cc", "aba", "aca", "bab", "bcb", "cac", "cbc", "abba", "acca", "baab", "bccb", "caac", "cbbc". 
# Constraints:
# 1 ≤ k ≤ 26
# 1 ≤ n ≤ 52
# n ≤ 2*k


class Solution:
    def palindromicStrings(self, n, k):
    # code here

        def count(n, k, m):
            ans = 1
            for _ in range(n):
                ans = (ans*k)%m
                k -= 1
            return ans
    
        M = 10**9+7
        cnt = 0
        for i in range(1, n+1):
            cnt = (cnt+count((i+1)//2, k, M))%M
    
        return cnt