# Ways to Increase LCS by One
# Difficulty: MediumAccuracy: 22.73%Submissions: 3K+Points: 4
# Given two strings s1 and s2 consisting of lowercase English letters of length n1 and n2 respectively, find the number of ways to insert exactly one character into string s1 such that the length of the Longest Common Subsequence (LCS) of both strings increases by exactly 1.

# Examples :

# Input: s1 = "abab", s2 = "abc"
# Output: 3
# Explanation: The LCS length of the given two strings is 2. There are 3 valid insertions in s1 which increase the LCS length to 3:
# "abcab" -> LCS = 3
# "abacb" -> LCS = 3
# "ababc" -> LCS = 3
# Input: s1 = "abcabc", s2 = "abcd"
# Output: 4
# Explanation: The LCS length of the given two strings is 3. There are 4 valid insertions in s1 which increase the LCS length to 4:
# "abcdabc" -> LCS = 4
# "abcadcb" -> LCS = 4
# "abcabdc" -> LCS = 4
# "abcabcd" -> LCS = 4


class Solution:
     def waysToIncreaseLCSBy1(self, s1, s2):
        n1, n2 = len(s1), len(s2)
        prefix_lcs = [[0] * (n2 + 1) for _ in range(n1 + 1)]
        for i in range(n1):
            for j in range(n2):
                if s1[i] == s2[j]:
                    prefix_lcs[i + 1][j + 1] = prefix_lcs[i][j] + 1
                else:
                    prefix_lcs[i + 1][j + 1] = max(prefix_lcs[i][j + 1], prefix_lcs[i + 1][j])
        suffix_lcs = [[0] * (n2 + 1) for _ in range(n1 + 1)]
        for i in reversed(range(n1)):
            for j in reversed(range(n2)):
                if s1[i] == s2[j]:
                    suffix_lcs[i][j] = suffix_lcs[i + 1][j + 1] + 1
                else:
                    suffix_lcs[i][j] = max(suffix_lcs[i][j + 1], suffix_lcs[i + 1][j])
        char_to_s2_pos = [[] for _ in range(26)]
        for i, c in enumerate(s2):
            char_to_s2_pos[ord(c) - ord("a")].append(i)
        lcs_len = prefix_lcs[-1][-1]
        ways_count = 0
        for gap_i in range(n1 + 1):
            for c_i in range(26):
                for pos_j in char_to_s2_pos[c_i]:
                    if prefix_lcs[gap_i][pos_j] + suffix_lcs[gap_i][pos_j + 1] == lcs_len:
                        ways_count += 1
                        break
        return ways_count

        # code here