# Minimum Moves to Sort Permutation
# Solved
# Difficulty: EasyAccuracy: 52.38%Submissions: 10K+Points: 2
# Given an array arr[] containing integers from 1 to n exactly once, sort the array in ascending order.

# In one operation, you can pick any element and move it either to the beginning or to the end of the array.

# Return the minimum number of operations required to sort the array.

# Examples:

# Input: arr[] = [2, 1, 3]
# Output: 1
# Explanation: Move 1 to the beginning.
# Input: arr[] = [4, 3, 1, 2]
# Output: 2
# Explanation: Move 3 to the end to get [4, 1, 2, 3]. Then move 4 to the end to get [1, 2, 3, 4].
# Constraints:

# arr.size() ≤ 105
# 1 ≤ arr[i] ≤ arr.size()

class Solution:
    def minMoves(self, arr):
        n = len(arr)
        atoi = [0] * (n + 1)
        for i in range(n):
            atoi[arr[i]] = i
        curr = lis = 1
        for i in range(1, n):
            if atoi[i] < atoi[i + 1]:
                curr += 1
                lis = max(lis, curr)
            else:
                curr = 1
        return n - lis