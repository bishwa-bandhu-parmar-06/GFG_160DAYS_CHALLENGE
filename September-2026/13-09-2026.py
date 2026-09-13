# Party in Town
# Difficulty: MediumAccuracy: 50.86%Submissions: 12K+Points: 4Average Time: 20m
# Geek Town has n houses numbered from 1 to n, choose a house to host a party such that its distance from its farthest house is as small as possible. Return this minimum possible distance.
# The houses are connected by n − 1 bidirectional roads, forming a tree. 
# The connections are given as an adjacency list adj, where adj[i] contains all houses directly connected to house i + 1. 
# Examples:

# Input: adj[][] = [[2], [1, 4, 3], [2], [2]] 

# Output: 1
# Explanation: Party should take place at house number 2. Maximum distance from house number 2 is 1.
# Input: adj[][] = [[2], [1, 3], [4, 2], [3]]

# Output: 2
# Explanation: Party should take place at house number 2 or 3. The minimum distance is 2.
# Constraints:

# 1 ≤ n ≤ 105
# 1 ≤ adj[i][j]
# adj.size() = n



from collections import deque

class Solution:
    def partyHouse(self, adj: list[list[int]]) -> int:
        def f(node):
            q = deque([(node, 0)])
            vis = {node}
            end = node
            cntt = 0

            while q:
                nodee, cnt = q.popleft()

                if cnt > cntt:
                    cntt = cnt
                    end = nodee

                for it in adj[nodee - 1]:
                    if it not in vis:
                        vis.add(it)
                        q.append((it, cnt + 1))

            return (end, cntt)

        end, cnt = f(1)
        end1, cnt = f(end)

        return (cnt + 1) // 2