# Node and Ancestor Max Diff
# Solved
# Difficulty: MediumAccuracy: 34.95%Submissions: 88K+Points: 4Average Time: 45m
# Given the root of a binary tree, find the maximum difference between an ancestor node A and its descendant node B, i.e., maximize A - B.

# Examples :

# Input: root[] = [5, 2, 1] 

# Output: 4
# Explanation: The maximum difference we can get is 4, which is between 5 and 1.
# Input: root[] = [1, 2, 3, N, N, N, 7] 

# Output: -1
# Explanation: The maximum difference we can get is -1, which is between 1 and 2.
# Constraints:

# 2 ≤ no. of nodes in root ≤ 104
# 0 ≤ root.node->data ≤ 105
# 2 ≤ Number of edges ≤ 104


''' Structure of Binary Tree Node
class Node:
    def __init__(self,val):
        self.data = val
        self.left = None
        self.right = None
'''
class Solution:
    def maxDiff(self, root):
        def dfs(cur=root):
            if not cur:
                return -float('inf'),float('inf')
            lmx,lmn=dfs(cur.left)
            rmx,rmn=dfs(cur.right)
            mx=max(lmx,rmx,cur.data-min(lmn,rmn))
            mn=min(cur.data,lmn,rmn)
            return mx,mn
        return dfs()[0]