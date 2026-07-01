# Max sum subarray by removing at most one element
# Difficulty: MediumAccuracy: 32.53%Submissions: 27K+Points: 4
# Given an array arr[], find the maximum sum of a non-empty subarray. You are allowed to skip at most one element in the subarray.

# Note: After skipping the element, the subarray must still be non-empty.

# Examples:

# Input: arr[] = [1, 2, 3, -4, 5]
# Output: 11
# Explanation: We can get maximum sum subarray by skipping -4.
# Input: arr[] = [-2, -3, 4, -1, -2, 1, 5, -3]
# Output: 9
# Explanation: We can get maximum sum subarray by skipping -2 as [4,-1,1,5] sums to 9, which is the maximum achievable sum.
# Constraints:
# 1 ≤ arr.size() ≤ 106
# -103 ≤ arr[i] ≤ 103



class Solution:
    def maxSumSubarray(self, arr):
        after_first_neg = False
        pos_s = 0
        s = 0
        lst = 0
        maxi = -sys.maxsize
        for i in arr:
            if i < 0:
                lst = min(i, lst)
                if after_first_neg and pos_s > s - lst + i:
                    s = pos_s
                    lst = i
                after_first_neg = True
            s += i
            pos_s += i
            maxi = max(maxi, s - lst)
            if pos_s < 0:
                pos_s = 0
        return max(arr) if maxi == 0 else maxi 