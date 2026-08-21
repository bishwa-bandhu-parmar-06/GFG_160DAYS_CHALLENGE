# Transform String
# Difficulty: MediumAccuracy: 29.76%Submissions: 49K+Points: 4
# Given two strings s1 and s2. Find the minimum number of steps required to transform string s1 into string s2. The only allowed operation for the transformation is selecting a character from string s1 and inserting it in the beginning of string s1.

# If transformation is not possible return -1.

# Examples:

# Input: s1 = "abd", s2 = "bad"
# Output: 1
# Explanation: The conversion can take place in 1 operation: Pick 'b' and place it at the front.
# Input: s1 = "GeeksForGeeks", s2 = "ForGeeksGeeks"
# Output: 3
# Explanation: The conversion can take place in 3 operations: 
# Pick 'r' and place it at the front.
# s1 = "rGeeksFoGeeks"
# Pick 'o' and place it at the front.
# s1 = "orGeeksFGeeks"
# Pick 'F' and place it at the front.
# s1 = "ForGeeksGeeks"
# Constraints:
# 1<= s1.length(), s2.length() <= 104


class Solution:
    def transform(self, s1, s2):
        from collections import Counter
        if Counter(s1) != Counter(s2):
            return - 1
        n = len(s1)
        j = n - 1
        for i in reversed(range(n)):
            if s1[i] == s2[j]:
                j -= 1
        return j + 1