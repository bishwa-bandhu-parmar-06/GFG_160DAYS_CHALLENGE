# Maximum Reachable Index Difference
# Difficulty: MediumAccuracy: 30.2%Submissions: 6K+Points: 4
# Given a string s containing lowercase English alphabets.

# Start from any index containing the character 'a' and perform jump operations.
# In each jump operation, move to any index on the right side whose character is the immediate next letter of the current character in the alphabet (i.e., 'a' to 'b', 'b' to 'c', 'c' to 'd', and so on). 
# Continue performing jumps until no further jump is possible.
# Find the maximum possible difference between the starting index and the ending index. If it is not possible to choose a starting index, return -1.

# Examples :

# Input: s = "aaabcb"
# Output: 5
# Explanation: Start at index 0 ('a'), jump to index 5 ('b'). Difference = 5 - 0 = 5.
# Input: s = "xynjir"
# Output: -1
# Explanation: The string does not contain any character 'a'. So, the answer is -1.
# Input: s = "abcbzzd"
# Output: 6
# Explanation: Start from index 0 ('a'). Jump to index 1 ('b') because 'b' is the next alphabet character. Jump to index 2 ('c') because 'c' is the next character after 'b'. Jump to index 6 ('d') because 'd' is the next character after 'c'.
# Constraints:
# 1 ≤ s.size() ≤ 105

class Solution:
    def maxIndexDifference(self, s):
        start = end = -1
        max_c_i = -1
        for i, c in enumerate(s):
            c_i = ord(c)
            if c == "a":
                if max_c_i == -1:
                    start = end = i
                    max_c_i = c_i
            elif c_i - 1 <= max_c_i:
                end = i
                if c_i > max_c_i:
                    max_c_i = c_i
        return end - start if start > -1 else -1
        # code here
        