# Minimum Time to Finish Project
# Difficulty: MediumAccuracy: 52.2%Submissions: 4K+Points: 4
# An IT company is working on a large project consisting of n modules. The time required (in months) to complete the ith module is stored in the array duration[]. The array dependencies[][], where dependencies[i] = [u, v], indicates that module v can be started only after module u is completed. Multiple modules can be worked on simultaneously as long as all their dependencies have been completed. Find the minimum time required to complete the entire project. If the project cannot be completed due to a cyclic dependency, return -1.

# Note: A module is never dependent on itself.

# Examples

# Input: duration[] = [10, 20, 30, 10, 30, 20], dependencies[][] = [[5, 2], [5, 0], [4, 0], [4, 1], [2, 3], [3, 1]]
# Output: 80
# Explanation: 

# The Graph of dependency forms this and the project will be completed when Module 1 is completed. The minimum taken time is 80 months, the maximum taken time is through the path 5 -> 2 -> 3 -> 1 which takes 20 + 30 + 10 + 20
# Input: duration[] = [5, 5, 5], dependencies[][] = [[0, 1], [1, 2], [2, 0]]
# Output: -1
# Explanation: There is a cycle in the dependency graph hence the project cannot be completed.
# Constraints:

# 1 ≤ duration.size() ≤ 105
# 0 ≤ duration[i] ≤ 105
# 0 ≤ m ≤ 2*105
# 0 ≤ dependencies[i][j] < 105



class Solution:
    def minTime(self, duration, dependencies):
        # code here
        from collections import defaultdict
        from heapq import heappush, heappop, heapify
        
        n = len(duration)
        degree = [0]*n
        g = defaultdict(list)
        
        for u, v in dependencies:
            g[u].append(v)
            degree[v] += 1
        q = [(duration[i], i) for i, c in enumerate(degree) if c == 0]
        heapify(q)
        cnt = 0
        ans = 0
        while q:
            t, u = heappop(q)
            ans = max(ans, t)
            cnt += 1
            for v in g[u]:
                degree[v] -= 1
                if degree[v] == 0:
                    heappush(q, (duration[v]+t, v))

        return ans if cnt == n else -1