# Minimum Absolute Difference In BST
# Difficulty: MediumAccuracy: 56.22%Submissions: 36K+Points: 4Average Time: 30m
# Given the root of a Binary Search Tree (BST) containing n (n > 1) nodes, find the minimum absolute difference between the values of any two different nodes in the tree.

# Return the minimum absolute difference.

# Examples:

# Input: root[] = [50, 30, 70, 20, N, 60, 80]
# 420046990
# Output: 10
# Explanation: There are no two nodes whose absolute difference is smaller than 10.
# Input: root[] = [60, 30, 90, 10]
# 2056957925
# Output: 20
# Explanation: There are no two nodes whose absolute difference is smaller than 20.
# Constraints:

# 2 ≤ size of binary tree ≤ 105
# 0 ≤ node.data ≤ 106


'''
Binary Tree Node Structure
class Node:
    def __init__(self):
        self.data = None
        self.left = None
        self.right = None
'''
        
class Solution:
    def absDiff(self, root):
        MAX = 10 ** 6

        def dfs(node: Node) -> tuple[int, int]:
            mini = maxi = node.data
            min_abs_diff = MAX
            if node.left:
                mini, left_max, left_diff = dfs(node.left)
                min_abs_diff = min(left_diff, node.data - left_max)
            if node.right:
                right_min, maxi, right_diff = dfs(node.right)
                min_abs_diff = min(min_abs_diff, right_diff, right_min - node.data)
            return mini, maxi, min_abs_diff

        return dfs(root)[2]