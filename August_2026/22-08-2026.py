# Number of Turns in Binary Tree
# Solved
# Difficulty: HardAccuracy: 42.63%Submissions: 28K+Points: 8
# Given root of a binary tree and the values of its two nodes p and q, count turns required to travel from node p to q.

# A turn occurs whenever the direction of movement changes from left to right or right to left while traversing the tree.
# If the path between the two nodes does not involve any turns (i.e., the nodes lie on the same straight path), return -1.
# Note: All node values are distinct.

# Examples :

# Input: root[] = [1, 2, 3, 4, 5, 6, 7, 8, N, N, N, 9, 10], p = 5, q = 10

# Output: 4
# Explanation: The path from node 5 to node 10 is: 5 -> 2 -> 1 -> 3 -> 6 → 10. Direction changes occur at nodes 2, 1, 3, and 6. Therefore, the number of turns is 4.
# Input: root[] = [1, 2, 3, 4, 5, 6, 7, 8, N, N, N, 9, 10], p = 1, q = 4

# Output: -1
# Explanation: No turn is required since they are in a straight line.
# Constraints:
# 1 ≤ n ≤ 104, n is the number of nodes
# 1 ≤ node->data ≤ 104
# 1 ≤ p, q ≤ n


class Solution:
    def numberOfTurns(self, root, p, q):
        def f(r,x,a):
            if not r: return False
            if r.data == x: return True
            a.append('L')
            if f(r.left,x,a): return True
            a.pop();a.append('R')
            if f(r.right,x,a): return True
            a.pop()
        a,b = [],[]
        f(root,p,a)
        f(root,q,b)
    
        i=0
        while i< min(len(a), len(b)) and a[i] == b[i]:
            i += 1
        a = a[i:][::-1] + b[i:]
        ans = sum(a[i] != a[i-1] for i in range(1,len(a)))
        return ans or -1