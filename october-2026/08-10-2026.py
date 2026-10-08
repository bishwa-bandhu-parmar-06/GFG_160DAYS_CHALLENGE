# Maximum Frequency with K Increments
# Difficulty: MediumAccuracy: 67.31%Submissions: 7K+Points: 4Average Time: 30m
# Given an integer array arr[]. In one operation, you can choose an index and increment its value by 1.

# Find the maximum possible frequency of any element after performing at most k operations.

# Examples:

# Input: arr[] = [2, 2, 4], k = 4
# Output: 3
# Explanation: Apply two increment operations on index 0 and two operations on index 1 to make arr[]= [4, 4, 4]. Frequency of 4 is 3.
# Input: arr[] = [7, 7, 7, 7], k = 5
# Output: 4
# Explanation: The frequency of 7 is already 4, so no operations are needed.
# Constraints:

# 1 ≤ arr.size() ≤ 105
# 1 ≤ arr[i] ≤ 106
# 0 ≤ k ≤ 105


class Solution:
    def maxFrequency(self, arr, k):
        arr.sort()

        left = 0
        total = 0
        ans = 1

        for right in range(len(arr)):
            total += arr[right]

            # Cost to make all elements in the window equal to arr[right]
            cost = arr[right] * (right - left + 1) - total

            # If cost exceeds k, shrink the window
            while cost > k:
                total -= arr[left]
                left += 1
                cost = arr[right] * (right - left + 1) - total

            ans = max(ans, right - left + 1)

        return ans