# N-Digit Numbers with Increasing Digits
# Difficulty: MediumAccuracy: 49.66%Submissions: 25K+Points: 4
# Given an integer n, return all the n digit numbers in increasing order, such that their digits are in strictly increasing order(from left to right).

# Examples :

# Input: n = 1
# Output: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
# Explanation: Single digit numbers are considered to be strictly increasing order.
# Input: n = 2
# Output: [12, 13, 14, 15, 16, 17, 18, 19, 23....79, 89]
# Explanation: For n = 2, the correct sequence is 12 13 14 15 16 17 18 19 23 and so on up to 89.
# Input: n = 15
# Output: []
# Explanation: No such number exist. 
# Constraints:
# 1 ≤ n ≤ 105



class Solution:
    def increasingNumbers(self, n):
        if n == 1:
            return [i for i in range(10)]

        if n > 9:
            return []

        ans = []

        def backtrack(start, length, num):
            if length == n:
                ans.append(num)
                return

            for digit in range(start, 10):
                backtrack(digit + 1, length + 1, num * 10 + digit)

        backtrack(1, 0, 0)
        return ans

