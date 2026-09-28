# Range GCD Queries
# Difficulty: MediumAccuracy: 67.72%Submissions: 9K+Points: 4Average Time: 45m
# Given an integer array arr[] and a 2D array queries[][] containing q queries, where each query is one of the following two types:

# Type 1: [0, l, r] -> Return the GCD of all elements in the range [l, r] (both inclusive).
# Type 2: [1, index, value] -> Update arr[index] to value.
# Return an array containing the answers to all Type 1 queries in the order they appear in queries[][].

# Note: Use 0-based indexing.

# Examples:

# Input: arr[] = [2, 3, 4, 6, 8, 16], q = 3, queries[][] = [[0, 0, 2], [1, 3, 8], [0, 2, 5]]
# Output: [1, 4]
# Explanation: Initially, arr[] = [2, 3, 4, 6, 8, 16].
# Query [0, 0, 2]: Find the GCD of the subarray arr[0...2] = [2, 3, 4]. The GCD is 1.
# Query [1, 3, 8]: Update arr[3] from 6 to 8. The array becomes [2, 3, 4, 8, 8, 16].
# Query [0, 2, 5]: Find the GCD of the subarray arr[2...5] = [4, 8, 8, 16]. The GCD is 4.
# Therefore, the answers to all Type 0 queries are [1, 4].
# Input: arr[] = [12, 18, 24, 30, 36], q = 4, queries[][] = [[0, 1, 3], [1, 2, 15], [0, 0, 2], [0, 2, 4]]
# Output: [6, 3, 3]
# Explanation: Initially, arr[] = [12, 18, 24, 30, 36].
# Query [0, 1, 3]: Find the GCD of the subarray arr[1...3] = [18, 24, 30]. The GCD is 6.
# Query [1, 2, 15]: Update arr[2] from 24 to 15. The array becomes [12, 18, 15, 30, 36].
# Query [0, 0, 2]: Find the GCD of the subarray arr[0...2] = [12, 18, 15]. The GCD is 3.
# Query [0, 2, 4]: Find the GCD of the subarray arr[2...4] = [15, 30, 36]. The GCD is 3.
# Therefore, the answers to all Type 0 queries are [6, 3, 3].
# Constraints:
# 1 ≤ arr.size() ≤ 105
# 1 ≤ q ≤ 105
# 0 ≤ l, r, index ≤ arr.size()-1
# 1 ≤ arr[i], value ≤ 105



import math
class SegmentTree:
    def __init__(self, arr: list[int]):
        self.n = len(arr)
        # Allocate memory for the segment tree
        self.tree = [0] * (4 * self.n)
        if self.n > 0:
            self.build(arr, 0, 0, self.n - 1)
    def build(self, arr: list[int], node: int, start: int, end: int):
        if start == end:
            self.tree[node] = arr[start]
            return
        mid = (start + end) // 2
        left_child = 2 * node + 1
        right_child = 2 * node + 2

        self.build(arr, left_child, start, mid)
        self.build(arr, right_child, mid + 1, end)
        self.tree[node] = math.gcd(self.tree[left_child], self.tree[right_child])
    def update(self, node: int, start: int, end: int, idx: int, val: int):
        if start == end:
            self.tree[node] = val
            return
        mid = (start + end) // 2
        left_child = 2 * node + 1
        right_child = 2 * node + 2

        if start <= idx <= mid:
            self.update(left_child, start, mid, idx, val)
        else:
            self.update(right_child, mid + 1, end, idx, val)
        self.tree[node] = math.gcd(self.tree[left_child], self.tree[right_child])
    def query(self, node: int, start: int, end: int, l: int, r: int) -> int:
        # Range completely outside the segment
        if r < start or end < l:
            return 0
        # Range completely covers the segment
        if l <= start and end <= r:
            return self.tree[node]
        mid = (start + end) // 2
        left_gcd = self.query(2 * node + 1, start, mid, l, r)
        right_gcd = self.query(2 * node + 2, mid + 1, end, l, r)
        return math.gcd(left_gcd, right_gcd)
class Solution:
    def processQueries(self, arr: list[int], queries: list[list[int]]) -> list[int]:
        if not arr:
            return []
        seg_tree = SegmentTree(arr)
        ans = []
        n = len(arr)
        for q in queries:
            if q[0] == 0:    # Type 1: Range GCD query [0, l, r]
                l, r = q[1], q[2]
                ans.append(seg_tree.query(0, 0, n - 1, l, r))
            elif q[0] == 1:  # Type 2: Point update query [1, index, value]
                idx, val = q[1], q[2]
                seg_tree.update(0, 0, n - 1, idx, val)
        return ans