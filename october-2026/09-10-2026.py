# Minimum Operations to Reach n
# Difficulty: EasyAccuracy: 60.02%Submissions: 109K+Points: 2
# Given a number n. Find the minimum number of operations required to reach n starting from 0.

# You have two operations available:

# Double the number
# Add one to the number
# Examples:

# Input: n = 8
# Output: 4
# Explanation: 0 + 1 = 1 --> 1 + 1 = 2 --> 2 * 2 = 4 --> 4 * 2 = 8.
# Input: n = 7
# Output: 5
# Explanation: 0 + 1 = 1 --> 1 + 1 = 2 --> 1 + 2 = 3 --> 3 * 2 = 6 --> 6 + 1 = 7.
# Constraints:

# 1 ≤ n ≤ 106


class Solution:
    def minOperation(self, n):
        return n.bit_length() + n.bit_count() - 1