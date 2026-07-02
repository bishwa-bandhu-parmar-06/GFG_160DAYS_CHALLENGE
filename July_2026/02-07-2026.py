# Check Subset sum divisible by k
# Difficulty: MediumAccuracy: 22.41%Submissions: 21K+Points: 4
# Given an array arr[] of positive integers and a value k. Return true if the sum of any non-empty subset of the given array is divisible by k otherwise, return false.

# Examples:

# Input: arr[] = [3, 1, 7, 5] , k = 6
# Output: true
# Explanation: If we take the subset {7, 5} then sum will be 12 which is divisible by 6.
# Input: arr[] = [1, 2, 6] , k = 5
# Output: false
# Explanation: All possible subsets of the given set are {1}, {2}, {6}, {1, 2}, {2, 6}, {1, 6} and {1, 2, 6}. There is no subset whose sum is divisible by 5.
# Constraints:
# 1 ≤ arr.size(), k ≤ 103
# 1 ≤ arr[i] ≤ 103


class Solution:
    def divisibleByK(self, arr, k):
        # code here
        dp = [[False] * k for _ in range(len(arr) + 1)]
        dp[0][0] = True
        for i, v in enumerate(arr):
            for j in range(k):
                if dp[i][j]:
                    dp[i+1][j] = True
                    rem = (j + v) % k
                    if rem == 0:
                        return True
                    dp[i+1][rem] = True
        return False