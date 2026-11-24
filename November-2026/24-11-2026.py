# Two Pairs with Same Sum
# Difficulty: MediumAccuracy: 50.31%Submissions: 17K+Points: 4Average Time: 15m
# Given an array arr[] of positive integers, find four indices a, b, c, and d such that arr[a] + arr[b] = arr[c] + arr[d], where a, b, c, d are all distinct indices.

# If multiple such quadruplets exist, return the one that is lexicographically smallest when the indices are considered in the order a, b, c, d.
# If no such quadruplet exists, return {-1, -1, -1, -1}. 
# Ensure a < b and c < d, and the pair (a, b) is lexicographically smaller than the pair (c, d).
# Examples:

# Input: arr[] = [3, 4, 7, 1, 2, 9, 8]
# Output: [0, 2, 3, 5]
# Explanation: arr[0] + arr[2] = 3 + 7 = 10, arr[3] + arr[5] = 1 + 9 = 10. 
# This is the lexicographically smallest such quadruplet of indices.
# Input: arr[] = [1, 2, 3, 3]
# Output: [-1, -1, -1, -1]
# Explanation: No two distinct pairs of indices produce the same sum.
# Constraints:

# 4 ≤ arr.size() ≤ 103
# 1 ≤ arr[i] ≤ 107


class Solution:
    def findPairs(self, arr: list[int]) -> list[int]:
            n = len(arr)
            pairs = {}
            ans = [n, n, n, n]
            for c in range(n - 1):
                for d in range(c + 1, n):
                    sumi = arr[c] + arr[d]
                    if sumi in pairs:
                        a, b = pairs[sumi]
                        if a != c and a != d and b != c and b != d:
                            ans = min(ans, [a, b, c, d])
                    else:
                        pairs[sumi] = (c, d)
            return ans if ans[0] != n else [-1, -1, -1, -1]