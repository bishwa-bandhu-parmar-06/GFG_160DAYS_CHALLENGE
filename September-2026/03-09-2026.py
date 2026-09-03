# Max Adjacent Diffs Sum with 1 Replacements
# Solved
# Difficulty: MediumAccuracy: 57.15%Submissions: 9K+Points: 4
# Given an integer array arr[], you are allowed to replace any elements with 1.  Find the maximum sum of absolute differences between consecutive elements after any number of modifications.

# Examples:

# Input: arr[] = [3, 2, 1, 4, 5]
# Output: 8
# Explanation: Modify the array as arr[] = [3, 1, 1, 4, 1]. 
# Sum = |1-3| + |1-1| + |4-1| + |1-4| = 8, the maximum possible.
# Input: arr[] = [1, 5]
# Output: 4
# Explanation: No modification needed. Sum = |5-1| = 4.
# Constraints:

# 1 ≤ arr.size() ≤ 105


class Solution:
 def maxDiffSum(self, arr):
    a = 0
    b = 0

    for i in range(1, len(arr)):
        x = max(
            a + abs(arr[i] - arr[i-1]),
            b + abs(arr[i] - 1)
        )

        y = max(
            a + abs(1 - arr[i-1]),
            b
        )

        a, b = x, y

    return max(a, b)