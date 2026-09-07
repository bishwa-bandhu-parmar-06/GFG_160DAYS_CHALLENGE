# Minimum Elements Outside Subsequences
# Difficulty: HardAccuracy: 51.06%Submissions: 3K+Points: 8
# Given an array arr[] of size n, partition its elements into a strictly increasing subsequence and a strictly decreasing subsequence.

# Each element can belong to at most one of these subsequences, and some elements may remain unused.

# Determine the minimum number of elements that cannot be included in either subsequence.

# Examples:

# Input: arr[] = [7, 8, 1, 2, 4, 6, 3, 5, 2, 1, 8, 7]
# Output: 2
# Explanation: One possible increasing subsequence is: [1, 2, 4, 5, 8]. One possible decreasing subsequence is: [7, 6, 3, 2, 1]. The remaining elements are 8 and 7, so the minimum number of unselected elements is 2.
# Input: arr[] = [1, 4, 2, 3, 3, 2, 4]
# Output: 0
# Explanation: One possible increasing subsequence is: [1, 2, 3, 4]. One possible decreasing subsequence is: [4, 3, 2]. All elements are included in one of the two subsequences.
# Constraints:
# 1 ≤ n ≤ 100
# 1 ≤ arr[i] ≤ 100


class Solution:
    def minCount(self, arr):
            from functools import cache
            n = len(arr)

            @cache
            def dfs(i: int = 0, inc: int = -1, dec: int = -1) -> int:
                if i == n:
                    return 0
                used = dfs(i + 1, inc, dec)
                a = arr[i]
                if inc == -1 or a > inc:
                    used = max(used, 1 + dfs(i + 1, a, dec))
                if dec == -1 or a < dec:
                    used = max(used, 1 + dfs(i + 1, inc, a))
                return used

            return n - dfs()