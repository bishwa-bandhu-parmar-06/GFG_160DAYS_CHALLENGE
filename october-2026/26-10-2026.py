# Minimize Max Min Diff with Subarray Removal
# Difficulty: MediumAccuracy: 54.13%Submissions: 38K+Points: 4
# You are given an array arr[] of size n. You need to remove a subarray of size k , such that the difference between the maximum and minimum values of the remaining array is minimized. Find the minimum value obtained after performing the operation of the removal of the subarray.

# Examples:

# Input: arr = [1, 2, 3, 4, 5], k = 3 
# Output: 1
# Explanation: We remove first subarray of length 3, the remaining array is [4,5] and the difference of maximum and minimum element is 1 i.e 5 - 4 = 1
# Input: arr = [2, 3, 1, 4, 6, 7], k = 3
# Output: 2
# Explanation: 
# If we remove the subarray [2,3,1] then remaining array is [4,6,7] and the difference  = 7-4 = 3
# If we remove the subarray [3,1,4] then remaining array is [2,6,7] and the difference  = 7-2 = 5
# If we remove the subarray [1,4,6] then remaining array is [2,3,7] and the difference  = 7-2 = 5
# If we remove the subarray [4,6,7] then remaining array is [2,3,1] and the difference  = 3-1 = 2
# So the answer is min(3,5,5,2) = 2
# Constraints:

# 1 ≤ arr.size() ≤ 105
# 1 ≤ arr[i] ≤ 109
# 0 ≤ k < arr.size()



class Solution:
    def minDiff(self, k: int, arr: list[int]) -> int:
            from itertools import accumulate
            if k == 0:
                return max(arr) - min(arr)
            n = len(arr)
            if k == n - 1:
                return 0
            prefix_min = list(accumulate(arr[:n - k], min, initial=10**9))
            prefix_max = list(accumulate(arr[:n - k], max, initial=1))
            diff = prefix_max[-1] - prefix_min[-1]
            suffix_min = suffix_max = arr[-1]
            for i in range(n - 1, k - 1, -1):
                if arr[i] < suffix_min:
                    suffix_min = arr[i]
                elif arr[i] > suffix_max:
                    suffix_max = arr[i]
                diff = min(diff, max(prefix_max[i - k], suffix_max) - min(prefix_min[i - k], suffix_min))
            return diff