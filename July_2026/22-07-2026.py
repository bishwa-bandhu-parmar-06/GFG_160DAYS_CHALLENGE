# Minimum Deletions to Make Sorted
# Difficulty: EasyAccuracy: 49.53%Submissions: 13K+Points: 2
# Given an array arr[], find the minimum number of elements to delete so that the remaining elements form a strictly increasing sequence in the same order.

# Examples:

# Input: arr[] = [5, 6, 1, 7, 4]
# Output: 2
# Explanation: Removing 1 and 4 leaves [5, 6, 7] which is strictly increasing.
# Input: arr[] = [1, 1, 1]
# Output: 2
# Explanation: Removing any 2 elements leaves [1] which is strictly increasing.
# Constraints:
# 1 ≤ n ≤ 105 
# 1 ≤ arr[i] ≤ 105


class Solution:
    def minDeletions(self, arr):
        from bisect import bisect_left
        lis = []
        for a in arr:
            i = bisect_left(lis, a)
            if i == len(lis):
                lis.append(a)
            else:
                lis[i] = a
        return len(arr) - len(lis)