# Lexicographically Smallest Rotation
# Difficulty: HardAccuracy: 58.11%Submissions: 568+Points: 8
# Given a string s, find the lexicographically smallest string after rotating the string left any number of times including 0.

# Example:

# Input: s = "abcd"
# Output: "abcd"
# Explanation: String after each rotation are "abcd", "bcda", "cdab", "dabc" and so on. Lexicographically smallest among them is "abcd".
# Input: s = "baca"
# Output: "abac"
# Explanation: Strings after each rotation are "baca", "acab", "caba", "abac" and so on. Lexicographically smallest among them is "abac".
# Constraints:

# 1 ≤ s.size() ≤ 106
# s consists only of lowercase English alphabets


class Solution:
    def lexiString(self, s: str) -> str:
        n = len(s)
        t = s + s
        i = 0
        j = 1
        k = 0

        while i < n and j < n and k < n:
            if t[i + k] == t[j + k]:
                k += 1
                continue

            if t[i + k] > t[j + k]:
                i = i + k + 1
            else:
                j = j + k + 1

            if i == j:
                j += 1

            k = 0

        start = min(i, j)
        return t[start:start + n]