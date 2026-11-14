# Max Equal Sum in 3 Stacks
# Difficulty: MediumAccuracy: 48.71%Submissions: 51K+Points: 4Average Time: 20m
# Given three stacks s1, s2, and s3, represented by arrays where the first element of each array represents the top of the corresponding stack.

# Find the maximum possible equal sum(sum of all elements) of all three stacks by removing zero or more elements from the top of each stack.

# If it is not possible to make the sum of all three stacks equal, return 0.

# Examples:

# Input: s1 = [3, 2, 1, 1, 1], s2 = [4, 3, 2], s3 = [2, 5, 4, 1]
# Output: 5
# Explanation: Remove 3 from s1, 4 from s2, and 2, 5 from s3. The remaining sums of all three stacks are equal to 5.
# pop
# Input: s1 = [4,7], s2 = [10], s3 = [1,2,3]
# Output: 0
# Explanation: It is not possible to make the sums of all three stacks equal by removing elements from their tops.
# Constraints:

# 1 ≤ s1.size(), s2.size(), s3.size() ≤ 5 * 105
# 1 ≤ s1[i], s2[i], s3[i] ≤ 103


class Solution:
    def maxEqualSum(self, s1: list[int], s2: list[int], s3: list[int]) -> int:
        m, n, o = len(s1), len(s2), len(s3)
        sum1 = sum2 = sum3 = 0
        j, k = n - 1, o - 1
        max_common_sum = 0
        for i in range(m - 1, -1, -1):
            sum1 += s1[i]
            while j >= 0 and sum2 < sum1:
                sum2 += s2[j]
                j -= 1
            if sum2 != sum1:
                if sum2 < sum1 and j < 0:
                    break
                else:
                    continue
            while k >= 0 and sum3 < sum1:
                sum3 += s3[k]
                k -= 1
            if sum3 == sum1:
                max_common_sum = sum1
            elif sum3 < sum1 and k < 0:
                break
        return max_common_sum