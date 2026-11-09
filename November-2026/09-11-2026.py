# Count Group Occurrences
# Solved
# Difficulty: EasyAccuracy: 27.88%Submissions: 52K+Points: 2
# Given a string s and an integer k, count the number of distinct characters that appear in exactly k groups in the string.

# A group is defined as one or more consecutive occurrences of the same character. For example, in the string "aaabbcca", the groups are "aaa", "bb", "cc" and "a".

# Examples:

# Input: s = "abc", k = 1
# Output: 3
# Explanation: The characters 'a', 'b' and 'c' each appear in exactly one group.
# Input: s = "geeksforgeeks", k = 2
# Output: 4
# Explanation: The characters 'g', 'e', 'k' and 's' each appear in exactly two groups.
# Input: s = "aaaaa", k = 2
# Output: 0
# Explanation: The character 'a' appears in only one group, so no character appears in exactly two groups.
# Constraints:

# 1 ≤ s.size() ≤ 105
# 1 ≤ k ≤ 103
# s consists only of lowercase English alphabets



class Solution:
    def getCount (self, s, k):
            from collections import Counter
            from itertools import pairwise
            freqs = Counter()
            freqs[s[0]] += 1
            for a, b in pairwise(s):
                if a != b:
                    freqs[b] += 1
            return sum(c == k for c in freqs.values())