# Equalize All Prefix Sums
# Difficulty: MediumAccuracy: 69.73%Submissions: 19K+Points: 4
# Given a sorted array arr[]. For each i(0 ≤ i ≤ n-1), make all the elements of the array from index 0 to i equal, using the minimum number of operations.

# In one operation you either increase or decrease the array element by 1. Return an array that contains the minimum number of operations for each i, to accomplish the above task.

# Note:  

# For each index i, consider the original array without applying modifications made for previous indices.
# Try to solve the problem using O(1) extra space (excluding the resultant array).



class Solution:
    def optimalArray(self, arr):
        n = len(arr)

        # Prefix sums
        prefix = [0] * (n + 1)
        for i in range(n):
            prefix[i + 1] = prefix[i] + arr[i]

        ans = []

        for i in range(n):
            mid = i // 2
            median = arr[mid]

            left_cost = median * (mid + 1) - prefix[mid + 1]
            right_cost = (prefix[i + 1] - prefix[mid + 1]) - median * (i - mid)

            ans.append(left_cost + right_cost)

        return ans