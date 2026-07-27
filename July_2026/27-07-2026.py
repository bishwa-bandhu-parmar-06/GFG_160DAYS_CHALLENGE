# Construct a Full Binary Tree
# Difficulty: MediumAccuracy: 74.63%Submissions: 26K+Points: 4
# Given two arrays pre[] and preMirror[] of size n containing unique elements, where pre[] represents the preorder traversal of a full binary tree and preMirror[] represents the preorder traversal of its mirror tree, construct the original full binary tree using these traversals.

# Note: A general binary tree cannot be uniquely constructed using these two traversals. However, a full binary tree can be constructed uniquely from the given traversals without any ambiguity.

# Examples:

# Input: pre[] = [0,1,2], preMirror[] = [0,2,1] 
# Output: [0, 1, 2]
# Explanation: The tree will look like

       
# Input: pre[] = [1, 2, 4, 5, 3, 6, 7], preMirror[] = [1, 3, 7, 6, 2, 5, 4]
# Output: [1, 2, 4, 5, 3, 6, 7]
# Explanation: The tree will look like


# Constraints:

# 1 ≤ pre.size() ≤ 105
# 0 ≤ pre[i] ≤ 109
# 1 ≤ preMirror.size() ≤ 105
# 0 ≤ preMirror[i] ≤ 109



''' Structure of Binary Tree Node
class Node:
    def __init__(self, val):
        self.data = val
        self.right = None
        self.left = None
'''

class Solution:
    def constructBinaryTree(self, pre, preMirror):
        i, j = 0, len(pre) - 1

        def build() -> Node:
            nonlocal i, j
            node = Node(pre[i])
            if pre[i] == preMirror[j]:
                i += 1
                j -= 1
            else:
                i += 1
                node.left = build()
                node.right = build()
                j -= 1
            return node

        return build()