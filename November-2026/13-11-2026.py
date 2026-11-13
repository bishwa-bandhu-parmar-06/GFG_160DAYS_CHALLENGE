# Common Nodes in Two BSTs
# Difficulty: MediumAccuracy: 51.7%Submissions: 81K+Points: 4Average Time: 20m
# Given the roots r1 and r2 of two Binary Search Trees (BST), find all nodes that are present in both trees i.e. the intersection nodes of the two BSTs.

# Return the common node values in sorted order.

# Examples:

# Input: r1 = [5, 1, 10, 0, 4, 7, N, N, N, N, N, N, 9], r2 = [10, 7, 20, 4, 9, N, N]  

# Output: [4, 7, 9, 10]
# Explanation: The values present in both BSTs are 4, 7, 9, and 10. Hence, the answer is [4, 7, 9, 10].
# Input: r1 = [10, 2, 11, 1, 3, N, N], r2 = [2, 1, 3]

# Output: [1, 2, 3]
# Explanation: The values 1, 2, and 3 are present in both BSTs. Hence, the answer is [1, 2, 3].
# Constraints:

# 1 ≤ size of binary trees ≤ 105
# 0 ≤ Node.data ≤ 109


''' 
Structure of a Binary Search Tree node
class Node:
    def __init__(self, val):
        self.data = val
        self.left = None
        self.right = None
'''

class Solution:
     def findCommon(self, r1: 'Node', r2: 'Node') -> list[int]:

        def inorder(node: "Node") -> "Iterator[Node]":
            s = [node]
            while s:
                node = s[-1]
                if node.left:
                    s.append(node.left)
                    node.left = None
                else:
                    s.pop()
                    if node.right:
                        s.append(node.right)
                        node.right = None
                    yield node

        common_values = []
        it1, it2 = inorder(r1), inorder(r2)
        n1, n2 = next(it1, None), next(it2, None)
        while n1 and n2:
            if n1.data == n2.data:
                common_values.append(n1.data)
                n1, n2 = next(it1, None), next(it2, None)
            elif n1.data < n2.data:
                n1 = next(it1, None)
            else:
                n2 = next(it2, None)
        return common_values   