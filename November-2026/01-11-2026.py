# Maximum Subarray Sum with One Square Allowed
# Difficulty: MediumAccuracy: 72.31%Submissions: 2K+Points: 4
# Given an integer array arr[], find the maximum subarray sum by squaring at most one element.

# Examples:

# Input: arr[] =  [-1, -2, 3, -2, 3]
# Output: 10
# Explanation: The subarray {3, -2, 3} with squaring -2 will give the maximum sum as 3 + 4 + 3 = 10.
# Input: arr[] =  [-4, -4, -2, 5, 2, -1]
# Output: 27
# Explanation: The subarray {5, 2} with squaring 5 will give a maximum sum of 25 + 2 = 27.
# Constraints:

# 1 ≤ arr.size() ≤ 105
# -103 ≤ arr[i] ≤ 103


class Solution:
    def maximumSubarray(self, arr: list[int]) -> int:
        dp0 = arr[0]
        dp1 = arr[0] * arr[0]

        ans = max(dp0, dp1)

        for x in arr[1:]:
            new_dp0 = max(x, dp0 + x)

            new_dp1 = max(
                x * x,
                dp1 + x,
                dp0 + x * x
            )

            dp0 = new_dp0
            dp1 = new_dp1

            ans = max(ans, dp0, dp1)

        return ans