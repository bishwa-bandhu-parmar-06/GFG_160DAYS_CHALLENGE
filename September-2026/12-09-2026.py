
# Max Product Subsequence of Size K
# Solved
# Difficulty: MediumAccuracy: 49.3%Submissions: 12K+Points: 4
# Given an array arr[] of integers and an integer k, find a subsequence of size k whose product is maximum among all possible subsequences of size k. Return the maximum product that can be obtained.

# Examples:

# Input: arr[] = [1, 2, 0, 3], k = 2
# Output: 6
# Explanation: Subsequence containing elements {2, 3} gives maximum product: 2*3 = 6
# Input: arr[] = [1, 2, -1, -3, -6, 4], k = 4
# Output: 144
# Explanation: Subsequence containing {2, -3, -6, 4} gives maximum product: 2*(-3)*(-6)*4 = 144
# Constraints:

# arr.size() ≤ 30
# -10 ≤ arr[i] ≤ 10
# 1 ≤ k ≤ arr.size()





class Solution:
    def maxProduct(self, arr: list[int], k: int) -> int:
        arr.sort()
        n = len(arr)
        prod = 1

        if arr[-1] <= 0 and (k % 2 == 1):
            for i in range(n - 1, n - 1 - k, -1):
                prod *= arr[i]
            return prod

        left = 0
        right = n - 1

        if k % 2 == 1:
            prod *= arr[right]
            right -= 1
            k -= 1

        while k > 0:
            left_prod = arr[left] * arr[left + 1]
            right_prod = arr[right] * arr[right - 1]

            if left_prod > right_prod:
                prod *= left_prod
                left += 2
            else:
                prod *= right_prod
                right -= 2
            k -= 2

        return prod