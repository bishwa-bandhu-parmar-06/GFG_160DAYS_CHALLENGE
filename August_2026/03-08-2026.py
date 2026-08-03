# Max Sum Subarray of Size at least K
# Difficulty: MediumAccuracy: 37.64%Submissions: 69K+Points: 4
# Given an array arr[] and an integer k, find the maximum sum among all contiguous subarrays having a length greater than or equal to k.

# Examples:

# Input: arr[] = [1, -2, 2, -3], k = 3
# Output: 1
# Explanation: The sub-array of length at least 3 that produces greatest sum is [1, -2, 2]
# Input: arr[] = [1, 1, 1, 1, 1, 1], k = 2
# Output: 6
# Explanation: The sub-array of length at least 2 that produces greatest sum is [1, 1, 1, 1, 1, 1]
# Input: arr[] = [-4, -2, 1, -3], k = 2
# Output: -1
# Explanation: The sub-array of length at least 2 that produces greatest sum is [-2, 1]

# Constraints:

# 1 ≤ arr.size() ≤ 105
# -104 ≤ arr[i] ≤ 104
# 1 ≤ k ≤ arr.size()



class Solution:
    def maxSumWithK(self, arr: list[int], k: int) -> int:
        n = len(arr)
        
        bestEnd = [0]*n
        bestEnd[0] = arr[0]
        for i in range(1,n):
            bestEnd[i] = max(arr[i],arr[i]+bestEnd[i-1])
        
        winsum = sum(arr[:k])
        ans = winsum
        
        for i in range(k,n):
            winsum = winsum + arr[i] - arr[i-k]
            ans = max(ans,winsum+bestEnd[i-k],winsum)
        return ans