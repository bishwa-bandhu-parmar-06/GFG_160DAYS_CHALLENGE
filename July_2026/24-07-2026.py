# Longest Consecutive Path in Binary tree
# Difficulty: MediumAccuracy: 30.58%Submissions: 20K+Points: 4
# Given the root of a Binary Tree, find the length of the longest path consisting of connected nodes such that each next node has a value exactly 1 greater than its parent.

# The path must move from parent to child only and follow increasing consecutive values.

# If no such path exists, return -1.

# Examples:

# Input: root[] = [1, 2, 3]

                                
# Output: 2
# Explanation : Longest sequence is 1, 2. So answer for this test case is 2.
# Input : root[] = [10, 20, 30, 40, N, 60, 90]

# Output : -1
# Explanation: For the above test case no sequence is possible. So output is -1.

# Constraints:

# 1 ≤ no. of nodes in root ≤ 105
# 1 ≤ root.node->data ≤ 105


'''
Structure of Binary Tree Node
class Node:
    def __init__(self, val):
        self.right = None
        self.data = val
        self.left = None
'''
class Solution:
    def longestConsecutive(self, root):

        def dfs(node, prev_val, prev_len):
            if node is None:
                return prev_len
            curr_len = prev_len + 1 if node.data == prev_val + 1 else 1
            return max(
                curr_len,
                dfs(node.left, node.data, curr_len),
                dfs(node.right, node.data, curr_len)
            )

        max_len = dfs(root, -1, -1)
        return max_len if max_len > 1 else -1
        