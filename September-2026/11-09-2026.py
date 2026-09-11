# Values with Equal Array Remainders
# Difficulty: EasyAccuracy: 69.84%Submissions: 6K+Points: 2
# Given an integer array arr[], count the number of positive integers k such that all elements of the array leave the same remainder when divided by k.

# If there are infinitely many such values of k, return -1.

# Examples:

# Input: arr[] = [38, 6, 34]
# Output: 3
# Explanation: 
# The values of k for which all elements leave the same remainder when divided by k are 1, 2, and 4.
# For k = 1, all elements leave remainder 0.
# For k = 2, all elements leave remainder 0.
# For k = 4, all elements leave remainder 2.
# No other positive integer satisfies the required condition. Hence, the answer is 3.
# Input: arr[] = [3, 2]
# Output: 1
# Explanation: 
# The only positive integer for which both elements leave the same remainder is 1, 
# since both numbers leave remainder 0 when divided by 1.
# Input: arr[] = [5, 5, 5]
# Output: -1
# Explanation: 
# All elements in the array are equal. Therefore, for every positive integer k, 
# all elements leave the same remainder when divided by k.
# Since there are infinitely many such values of k, the answer is -1.
# Constraints:

# 1 ≤ arr.size(), arr[i] ≤ 105


class Solution:
    def sameMod(self, arr):
            from math import gcd
            n = len(arr)
            g = 0
            for a in arr:
                g = gcd(g, abs(a - arr[0]))
            if g == 0:
                return -1
            div_count = 0
            i = 1
            while i * i < g:
                if g % i == 0:
                    div_count += 2
                i += 1
            if i * i == g:
                div_count += 1
            return div_count