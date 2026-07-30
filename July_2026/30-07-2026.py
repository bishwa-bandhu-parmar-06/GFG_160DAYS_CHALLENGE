# Maximum Subset XOR
# Difficulty: MediumAccuracy: 28.93%Submissions: 34K+Points: 4
# Given an array arr[], choose any subset of elements (possibly all elements) such that the XOR of the chosen elements is maximized.

# Examples:

# Input : arr[] = [2, 4, 5]
# Output: 7
# Explanation: The subset {2, 5} has the maximum XOR value.
# Input : arr[] = [9, 8, 5]
# Output: 13
# Explanation: The subset {8, 5} has the maximum XOR value.
# Constraints:

# 1 ≤ arr.size() ≤ 105
# 1 ≤ arr[i] ≤ 106

class Solution:
    def maxSubsetXOR(self, arr):
        # code here
        n = len(arr)
        index = 0

        for bit in range(31, -1, -1):
            max_index = -1

            for i in range(index, n):
                if arr[i] & (1 << bit):
                    max_index = i
                    break

            if max_index == -1:
                continue

            arr[index], arr[max_index] = arr[max_index], arr[index]

            for i in range(n):
                if i != index and (arr[i] & (1 << bit)):
                    arr[i] ^= arr[index]

            index += 1

        ans = 0
        for num in arr:
            ans = max(ans, ans ^ num)

        return ans