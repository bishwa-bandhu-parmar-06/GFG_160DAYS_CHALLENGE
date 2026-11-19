# Sort in Specific Order
# Solved
# Difficulty: MediumAccuracy: 52.55%Submissions: 58K+Points: 4
# Given an array arr[] of positive integers. Your need to sort them so that

# The first part of the array contains odd numbers sorted in descending order.
# The rest of the portion contains even numbers sorted in ascending order.
# Examples:

# Input: arr[] = [1, 2, 3, 5, 4, 7, 10]
# Output: [7, 5, 3, 1, 2, 4, 10]
# Explanation: 7, 5, 3, 1 are odd numbers in descending order and 2, 4, 10 are even numbers in ascending order.
# Input: arr[] = [0, 4, 5, 3, 7, 2, 1]
# Output: [7, 5, 3, 1, 0, 2, 4]
# Explanation: 7, 5, 3, 1 are odd numbers in descending order and 0, 2, 4 are even numbers in ascending order.
# Constraints:

# 1 ≤ arr.size() ≤ 105
# 0 ≤ arr[i] ≤ 109



class Solution:
    def sortIt(self, arr):
            arr.sort(key=lambda a: -a if a & 1 else a)
