# Count Pairs Divisible By K
# Difficulty: MediumAccuracy: 40.47%Submissions: 43K+Points: 4
# Given an array arr[] and positive integer k, count total number of pairs in the array whose sum is divisible by k.

# Examples:

# Input :  arr[] = [2, 2, 1, 7, 5, 3], k = 4
# Output : 5
# Explanation : There are five pairs possible whose sum is divisible by '4' i.e., (2, 2), (1, 7), (7, 5), (1, 3) and (5, 3).
# Input : arr[] = [5, 9, 36, 74, 52, 31, 42], k = 3
# Output : 7 
# Explanation : There are seven pairs whose sum is divisible by 3, i.e, (9, 36), (9,42), (74, 52), (36, 42), (74, 31), (31, 5) and (5, 52).
# Constraints :
# 1 ≤ |arr| ≤ 5*104
# 1 ≤ arr[i] ≤ 106
# 1 ≤ k ≤ 5*104


class Solution:
    def countKdivPairs(self, arr, k):
        reminder_counts = [0] * k
        count = 0
        for a in arr:
            r = a % k
            co_r = k - r if r else 0
            count += reminder_counts[co_r]
            reminder_counts[r] += 1
        return count   