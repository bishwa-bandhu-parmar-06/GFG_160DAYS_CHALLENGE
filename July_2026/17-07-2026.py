# Max Absolute Diff of Two Subarrays
# Difficulty: MediumAccuracy: 50.44%Submissions: 12K+Points: 4
# Given an array of integers arr[], find two non-overlapping contiguous sub-arrays such that the absolute difference between the sum of two sub-arrays is maximum.

# Examples :

# Input: arr[] = [-2, -3, 4, -1, -2, 1, 5, -3]
# Output: 12
# Explanation: Two subarrays are [-2, -3] and [4, -1, -2, 1, 5]
# Input: arr[] = [2, -1, -2, 1, -4, 2, 8]
# Output: 16
# Explanation: Two subarrays are [-1, -2, 1, -4] and [2, 8] 
# Constraints:
# 2 ≤ arr.size() ≤ 105
# -103 ≤ arr[i] ≤ 103


class Solution:
    def maxDiffSubArrays(self, arr):
        n = len(arr)
        if n < 2:
            return 0

        left_max = [0] * n
        left_min = [0] * n
        right_max = [0] * n
        right_min = [0] * n

        cur_max = cur_min = arr[0]
        left_max[0] = left_min[0] = arr[0]
        best_max = best_min = arr[0]

        for i in range(1, n):
            cur_max = max(arr[i], cur_max + arr[i])
            best_max = max(best_max, cur_max)
            left_max[i] = best_max

            cur_min = min(arr[i], cur_min + arr[i])
            best_min = min(best_min, cur_min)
            left_min[i] = best_min

        cur_max = cur_min = arr[n - 1]
        right_max[n - 1] = right_min[n - 1] = arr[n - 1]
        best_max = best_min = arr[n - 1]

        for i in range(n - 2, -1, -1):
            cur_max = max(arr[i], cur_max + arr[i])
            best_max = max(best_max, cur_max)
            right_max[i] = best_max

            cur_min = min(arr[i], cur_min + arr[i])
            best_min = min(best_min, cur_min)
            right_min[i] = best_min

        ans = 0
        for i in range(n - 1):
            ans = max(ans, abs(left_max[i] - right_min[i + 1]))
            ans = max(ans, abs(right_max[i + 1] - left_min[i]))

        return ans