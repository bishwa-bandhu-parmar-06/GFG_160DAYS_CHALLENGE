# Longest Colored Path
# Difficulty: HardAccuracy: 36.5%Submissions: 8K+Points: 8
# Given an undirected acyclic graph (tree) with n nodes numbered from 1 to n. Each node is colored either Red (R) or Blue (B).

# The colors of the nodes are given by a string s of length n, where:

# s[i] = 'R' means node i + 1 is Red.
# s[i] = 'B' means node i + 1 is Blue.
# You are also given a list of n - 1 edges edges[][], where each edges[i] = [u, v] represents an undirected edge between nodes u and v.

# You can start from any node and traverse along the edges to form a path.

# A path is called valid if, once you visit a Blue node, you cannot visit any Red node after it on the same path.

# In other words, a valid path must have the following form:

# Only Red nodes, or
# Only Blue nodes, or
# Some Red nodes followed by some Blue nodes.
# A path containing a pattern like Blue -> Red is invalid.
# Find the maximum number of nodes in a valid path.

# Examples:

# Input: s = "RBB", edges = [[1, 2], [1, 3]] 
  
# Output: 2
# Explanation: The longest path is either 1 -> 2 or 1 -> 3. In both cases, the length of the path is 2.
# Input: s = "BB", edges = [[1, 2]]
  
# Output: 2
# Explanation: The longest path is 1 -> 2. The length of the path is 2.
# Constraints:

# s.size() ≤ 105
# 1 ≤ edges[i][j] ≤ s.size()
# s consists only of the characters R and B
# edges.size() = s.size()-1



class Solution:

    def longestPath(self, s, edges):

        n = len(s)

        g = [[] for _ in range(n)]

 

        for u, v in edges:

            u -= 1

            v -= 1

            g[u].append(v)

            g[v].append(u)

 

        # Root the tree

        par = [-1] * n

        order = [0]

 

        for u in order:

            for v in g[u]:

                if v != par[u]:

                    par[v] = u

                    order.append(v)

 

        # Longest same-color path downward

        down = [1] * n

        ans = 1

 

        for u in order[::-1]:

            a = b = 0

 

            for v in g[u]:

                if par[v] == u and s[v] == s[u]:

                    x = down[v]

                    if x > a:

                        b, a = a, x

                    elif x > b:

                        b = x

 

            down[u] = a + 1

            ans = max(ans, a + b + 1)

 

        # Longest same-color path through parent

        up = [1] * n

 

        for u in order:

            a = b = 0

            who = -1

 

            for v in g[u]:

                if par[v] == u and s[v] == s[u]:

                    x = down[v]

                    if x > a:

                        b, a, who = a, x, v

                    elif x > b:

                        b = x

 

            for v in g[u]:

                if par[v] == u and s[v] == s[u]:

                    other = b if v == who else a

                    up[v] = 1 + max(up[u], other + 1)

 

        arm = [max(down[i], up[i]) for i in range(n)]

 

        # Join Red -> Blue

        for u, v in edges:

            u -= 1

            v -= 1

 

            if s[u] != s[v]:

                ans = max(ans, arm[u] + arm[v])

 

        return ans