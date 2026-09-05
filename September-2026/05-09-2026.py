# Longest Subsequence with Adjacent Diff as 1
# Difficulty: MediumAccuracy: 29.43%Submissions: 63K+Points: 4
# Given an array arr[] with n elements. find the longest subsequence such that the absolute difference between adjacent elements is one.

# Examples:

# Input : arr[] = [10, 9, 4, 5, 4, 8, 6]
# Output : 3
# Explanation: Longest subsequences with difference 1 are [10, 9, 8], [4, 5, 4] and [4, 5, 6].  # type: ignore
# Input : arr[] = [1, 2, 3, 2, 3, 7, 2, 1]
# Output : 7
# Explanation:  Longest subsequences with difference 1 is [1, 2, 3, 2, 3, 2, 1]. 
# Constraints:

# 1 ≤ arr.size(), arr[i] ≤ 106


class Solution:
    def longestSubseq(self, arr):
        from collections import defaultdict
        prv=defaultdict(int)
        mx=1
        for ve in arr:
            prv[ve]=max(prv[ve-1]+1,prv[ve+1]+1,1)
            mx=max(mx,prv[ve])
        return mx