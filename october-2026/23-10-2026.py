# Count Pairs Violating BST Property
# Difficulty: MediumAccuracy: 56.99%Submissions: 34K+Points: 4
# Given a binary tree, count pairs of nodes that violate any of the following Binary Search Tree (BST) properties.


# All values in the left subtree are strictly smaller.
# All values in the right subtree are strictly greater.
# Examples:

# Input: root[] = [10, 50, 40, N, N, 20, 30]
# 2056958715
# Output: 5
# Explanation: Pairs violating BST property are:-
# (10,50), 10 should be greater than its left child value.
# (40,30), 40 should be less than its right child value.
# (50,20), (50,30) and (50,40), maximum of left subtree of 10 is 50 greater than 20, 30 and 40 of its right subtree.
# Input: root[] = [80, 40, 30, 70, N, 60, 70]
# 2056958716
# Output: 9
# Explanation: There are total 9 pairs (80,30),(80,60),(80,70),(30,60),(40,70),(40,30),(70,30),(70,60),(70,70) which violate the BST properties.
# Constraints:

# 1 ≤ size of binary tree ≤ 5*104
# 1 ≤ node.data ≤ 109


''' BST Node Structure
class Node:
    def __init__(self, val):
        self.data = val
        self.left = None
        self.right = None
'''

class Solution:
    def pairsViolatingBST(self, root):
        s = [root]
        arr = []
        while s:
            if isinstance(s[-1], int):
                arr.append(s.pop())
            else:
                node = s.pop()
                if node.right:
                    s.append(node.right)
                s.append(node.data)
                if node.left:
                    s.append(node.left)
        inversions_count = 0

        def mergesort(arr: list[int]) -> list[int]:
            nonlocal inversions_count
            if len(arr) <= 1:
                return arr
            mid = len(arr) // 2
            brr = mergesort(arr[:mid])
            crr = mergesort(arr[mid:])
            i = j = 0
            bl, cl = len(brr), len(crr)
            arr.clear()
            while i < bl and j < cl:
                if brr[i] <= crr[j]:
                    arr.append(brr[i])
                    i += 1
                else:
                    arr.append(crr[j])
                    j += 1
                    inversions_count += bl - i
            if i < bl:
                arr.extend(brr[i:])
            elif j < cl:
                arr.extend(crr[j:])
            return arr

        mergesort(arr)
        return inversions_count