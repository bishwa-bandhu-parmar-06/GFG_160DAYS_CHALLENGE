# Complete Binary Tree Traversal with Array Input
# Difficulty: MediumAccuracy: 46.62%Submissions: 19K+Points: 4
# Given an integer array arr[] representing the nodes of a Complete Binary Tree in level order traversal, return the nodes at each level in sorted ascending order.

# For every level of the binary tree, sort the values present at that level independently and return the resulting levels as a 2D array, where the i-th row contains the sorted values of the i-th level.

# Examples:

# Input: arr[] = [7, 6, 5, 4, 3, 2, 1]
# Output: [[7], [5, 6], [1, 2, 3, 4]]
# Explanation: The complete binary tree formed from the given level order traversal is:   
        
# The nodes at each level after sorting are:
# Level 0: [7]
# Level 1: [5, 6]
# Level 2: [1, 2, 3, 4]
# Input: arr[] = [7, 16, 1, 4, 13]
# Output: [[7], [1, 16], [4, 13]]
# Explanation: The complete binary tree formed from the given level order traversal is:      
           
# The nodes at each level after sorting are:
# Level 0: [7]
# Level 1: [1, 16]
# Level 2: [4, 13]

# Constraints:

# 1 ≤ arr.size() ≤ 104
# 1 ≤ arr[i] ≤ 109



class Solution:
    def levelSort(self, arr):
        lth=len(arr)
        ret=[]
        q=[1]
        while q:
            ret.append(sorted([arr[ix-1] for ix in q]))
            nq=[]
            for cur in q:
                if cur*2<=lth:
                    nq.append(cur*2)
                if cur*2+1<=lth:
                    nq.append(cur*2+1)
            q=nq
        return ret