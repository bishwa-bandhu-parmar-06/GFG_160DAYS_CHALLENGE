# Balanced Binary Tree Counter
# Difficulty: EasyAccuracy: 38.47%Submissions: 32K+Points: 2Average Time: 10m
# Given a height h, find the maximum number of distinct balanced binary trees of height exactly h.

# A binary tree is balanced if, for every node, the heights of its left and right subtrees differ by at most 1. A tree with a single node has height 1. An empty tree has height 0.

# Note: Since the answer can be very large, return it modulo 109 + 7.

# Examples:

# Input: h = 1
# Output: 1
# Explanation: Only one tree of height 1 exists i.e. a single node.
# Input: h = 2
# Output: 3 
# Explanation: 3 distinct balanced trees of height 2 exist.

# Input: h = 3
# Output: 15
# Explanation: 15 distinct balanced trees of height 3 exist.

# Constraints:

# 1 ≤ h ≤ 106


class Solution:
    def countBT(self, h: int) -> int:
            # code here

            if h == 1 or h == 0:
                return 1

            M = 1_000_000_000+7

            a0, a1 = 1, 1 
            for _ in range(2, h+1):
                a1, a0 = ((a1*a0*2)%M + a1*a1%M)%M, a1

            return a1