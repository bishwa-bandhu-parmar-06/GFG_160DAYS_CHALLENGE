# Check Level Anagrams in Binary Trees
# Difficulty: MediumAccuracy: 56.88%Submissions: 23K+Points: 4
# Given the roots of two binary trees root1 and root2, check whether the nodes at every corresponding level of the two trees are anagrams of each other.

# Two levels are considered anagrams if they contain the same node values with the same frequencies, regardless of their order.

# Examples:

# Input: root1 = [1, 3, 2, N, N, 5, 4], root2 = [1, 2, 3, 4, 5, N, N]

# Output: true
# Explanation: 
# Level 0: [1] and [1]
# Level 1: [3, 2] and [2, 3]
# Level 2: [5, 4] and [4, 5]
# The node values at every corresponding level are anagrams of each other. Hence, the answer is true.
# Input: root1 = [1, 2, 3, 5, 4], root2 = [1, 2, 4, 5, 3]

# Output: false
# Explanation: 
# Level 0: [1] and [1]
# Level 1: [2, 3] and [2, 4]
# Since the node values at level 1 are not anagrams, the answer is false.
# Constraints:

# 1 ≤ size of binary tree ≤ 105
# 1 ≤ node.data ≤ 106
# The character N represents a null child.


"""
Structure of binary tree Node
class Node:
    def __init__(self, x: int):
        self.data = x
        self.left = self.right = None
"""


class Solution:

    def areAnagrams(self, root1, root2):
        from collections import deque, defaultdict
        q1, q2 = deque([root1]), deque([root2])
        while q1 and q2:
            freqs = defaultdict(int)
            for q, v in [(q1, 1), (q2, -1)]:
                for _ in range(len(q)):
                    node = q.popleft()
                    if node:
                        freqs[node.data] += v
                        q.extend((node.left, node.right))
            if any(freqs.values()):
                return False
        return q1 == q2