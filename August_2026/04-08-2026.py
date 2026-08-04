# Pairs with Less Than K Diff
# Solved
# Difficulty: EasyAccuracy: 38.07%Submissions: 8K+Points: 2
# Given an array arr[] of positive integers and an integer k, find the total number of pairs of elements that have an absolute difference strictly less than k.

# Note:  Pair (i, j) is considered the same as (j, i).

# Examples:

# Input : arr[] = [1, 10, 4, 2], k = 3
# Output : 2
# Explanation: We have an array arr[] = [1, 10, 4, 2] and k = 3 We can make only two pairs with a difference of less than 3. (1, 2) and (4, 2). So, the answer is 2.
# Input : arr[] = [2, 3, 4], k = 5
# Output : 3
# Explanation:  For the given array arr[] = [2, 3, 4] and k = 5, there are 3 valid pairs where the absolute difference between the pair's elements is less than 5. These pairs are (2, 3), (2, 4), and (3, 4). Hence, the output is 3.
# Constraints:
# 1 ≤ arr.size() ≤ 105
# 0 ≤ k ≤ 105
# 1 ≤ arr[i] ≤ 105



class Solution:
    def countPairs(self, arr: list[int], k: int) -> int:
        arr.sort()
        count = start = 0
        for end in range(1, len(arr)):
            while arr[end] - arr[start] >= k:
                start += 1
            count += end - start
        return count  
