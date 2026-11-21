# Smallest Subarray Sum Greater Than x
# Difficulty: EasyAccuracy: 37.07%Submissions: 174K+Points: 2Average Time: 20m
# Given an integer x and an array of integers, arr[]. Find the length of the smallest subarray whose sum is strictly greater than x.

# If no such subarray exists, return 0.

# Examples:

# Input: x = 51, arr[] = [1, 4, 45, 6, 0, 19]
# Output: 3
# Explanation: The smallest subarray with a sum greater than 51 is [4, 45, 6], whose sum is 55 and length is 3.
# Input: x = 100, arr[] = [1, 10, 5, 2, 7]
# Output: 0
# Explanation: No subarray has a sum greater than 100. Hence, the answer is 0.
# Constraints:

# 1 ≤ x, arr.size() ≤ 105
# 0 ≤ arr[i] ≤ 104


class Solution:
    def smallestSubWithSum(self, arr, x):
        mn=float('inf')
        sm=l=0
        for r in range(len(arr)):
            sm+=arr[r]
            while sm>x:
                mn=min(mn,r-l+1)
                sm-=arr[l]
                l+=1
        return mn if mn<float('inf') else 0