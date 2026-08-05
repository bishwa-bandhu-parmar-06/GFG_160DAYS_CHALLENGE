# Subarrays with Sum in Range
# Difficulty: HardAccuracy: 48.76%Submissions: 21K+Points: 8
# Given an integer array arr[] and two integers l and r, find the number of subarrays whose sum lies in the range [l, r] (inclusive).

# A subarray is a contiguous sequence of elements within the array.

# Examples:

# Input: l = 3, r = 8, arr[] = [1, 4, 6]
# Output: 3
# Explanation: The subarrays are [1,4], [4] and [6]. Therefore answer for this test case is 3.
# Input: l = 4, r = 13, arr[] = [2, 3, 5, 8]
# Output: 6
# Explanation: The subarrays are [2, 3], [2, 3, 5], [3, 5], [5], [5, 8] and [8]. 
# Therefore answer for this test case is 6.
# Constraints:
# 1 ≤ arr.size() ≤ 105
# 1 ≤ arr[i] ≤ 104
# 1 ≤ l ≤ r ≤ 109


def countSubarray(self, arr: list[int], l: int, r: int) -> int:
        curr_max = left = curr_min = right = count = 0
        for i, a in enumerate(arr):
            curr_max += a
            while left < i and curr_max > r:
                curr_max -= arr[left]
                left += 1
            curr_min += a
            while right < i and (m := curr_min - arr[right]) >= l:
                curr_min = m
                right += 1
            if l <= curr_min <= r:
                count += right - left + 1
        return count