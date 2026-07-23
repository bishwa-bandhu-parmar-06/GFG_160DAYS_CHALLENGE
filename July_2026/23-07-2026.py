# Check Preorder of BST
# Difficulty: MediumAccuracy: 36.84%Submissions: 44K+Points: 4Average Time: 20m
# Given an array arr[ ] consisting of distinct integers, check if the given array can represent preorder traversal of a BST.

# Examples :

# Input: arr[] = [2, 4, 3]
# Output: true
# Explaination: Given arr[] can represent preorder traversal of following BST:
 
# Input: arr[] = [2, 4, 1]
# Output: false
# Explaination: Given arr[] cannot represent preorder traversal of a BST.
# Constraints:
# 1 ≤ arr.size() ≤ 105
# 0 ≤ arr[i] ≤ 105



class Solution:
    def canRepresentBST(self, arr):
        stack = []
        root = float('-inf')

        for x in arr:
            if x < root:
                return 0

            while stack and stack[-1] < x:
                root = stack.pop()

            stack.append(x)

        return 1