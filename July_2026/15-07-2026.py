# Longest Bitonic Subarray
# Difficulty: MediumAccuracy: 38.09%Submissions: 16K+Points: 4
# Given an array arr[] of size n containing positive integers, return the maximum length of the bitonic subarray.

# A subarray arr[i...j] is considered bitonic if its elements first monotonically increase, and then monotonically decrease. Formally, there exists and index k (where i <= k <= j) such that:

# arr[i] <= arr[i+1] <= . . . <= arr[k] 
# arr[k] >= arr[k+1] >= . . . >= arr[j]
# Examples: 

# Input: arr[] = [12, 4, 78, 90, 45, 23]
# Output: 5
# Explanation: The longest bitonic subarray is [4, 78, 90, 45, 23], it starts increasing at 4, peaks at 90, and decreases to 23, giving length of 5.
# Input: arr[] = [10, 20, 30, 40]
# Output: 4
# Explanation: The array [10, 20, 30, 40] is striclty increasing with no decreasing part, so longest bitonic subarray is the entire array itself, giving a length of 4.
# Input: arr[] = [10, 10, 10, 10]
# Output: 4
# Constraints:
# 1 ≤  n ≤ 106
# 1 ≤ arr[i] ≤ 106

class Solution:
	def bitonic(self,arr):
        curr_inc = curr_dec = max_len = 0
        prev = arr[0]
        for a in arr:
            if prev == a:
                curr_inc += 1
                curr_dec += 1
                max_len = max(max_len, curr_inc, curr_dec)
            elif prev < a:
                curr_inc += 1
                curr_dec = 1
                max_len = max(max_len, curr_inc)
            else:  # a < prev
                curr_dec = max(curr_inc, curr_dec) + 1
                curr_inc = 1
                max_len = max(max_len, curr_dec)
            prev = a
        return max_len