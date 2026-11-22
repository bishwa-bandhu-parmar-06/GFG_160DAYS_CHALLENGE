# Longest Subarray Sum Divisible by K
# Difficulty: MediumAccuracy: 33.72%Submissions: 121K+Points: 4
# Given an array arr[] and a positive integer k, find the length of the longest subarray whose sum is divisible by k.

# Note: If there is no subarray with sum divisible by k, then return 0.

# Examples:

# Input: arr[] = [2, 7, 6, 1, 4, 5], k = 3
# Output: 4
# Explanation: The subarray [7, 6, 1, 4] has sum = 18, which is divisible by 3.
# Input: arr[] = [-2, 2, -5, 12, -11, -1, 7], k = 3
# Output: 5
# Explanation: The subarray [2, -5, 12, -11, -1] has sum = -3, which is divisible by 3.
# Input: arr[] = [1, 2, -2], k = 2
# Output: 2
# Explanation: The subarray is [2, -2] has sum = 0, which is divisible by 2.
# Constraints:

# 1 ≤ arr.size(), k ≤ 105
# -105 ≤ arr[i] ≤ 105


class Solution:
    def longestSubarrayDivK(self, arr, k):
        mx=sm=0
        prv={0:-1}
        for ix,ve in enumerate(arr):
            sm=(sm+ve)%k
            if sm in prv:
                mx=max(mx,ix-prv[sm])
            else:
                prv[sm]=ix
        return mx

