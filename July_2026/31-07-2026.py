# Subsets with Products of Distinct Primes
# Difficulty: HardAccuracy: 66.87%Submissions: 25K+Points: 8
# Given an integer array arr[], count the number of different subsets whose product can be represented as a product of one or more distinct prime numbers.  Two subsets are considered different if the set of chosen array indexes are not same.

# Return the count modulo 109 + 7.

# Examples:

# Input: arr[] = [1, 2, 3, 4]
# Output: 6
# Explanation: 
# The subsets are:
# [2], product = 2 = 2
# [3], product = 3 = 3
# [1, 2], product = 2 = 2
# [1, 3], product = 3 = 3
# [2, 3], product = 6 = 2 × 3
# [1, 2, 3], product = 6 = 2 × 3
# All these products can be expressed as a product of one or more distinct prime numbers. Hence, the count is 6.
# Note that [4] or any other subset with 4 are not chosen because prducts having 4 have repeated primes 2.
# Input: arr[] = [2, 2, 3]
# Output: 5
# Explanation: 
# Since subsets formed using different indices are considered different, the chosen subsets are:
# [2] (using the first 2)
# [2] (using the second 2)
# [3]
# [2, 3] (using the first 2)
# [2, 3] (using the second 2)
# Each subset has a product that can be expressed as a product of one or more distinct prime numbers. 
# Therefore, the answer is 5.

# Constraints:

# 1 ≤ arr.size() ≤ 105
# 1 ≤ arr[i] ≤ 30



class Solution:
    def countSubsets(self, arr):
        mod = 10**9 + 7

        freq = [0] * 31
        for x in arr:
            freq[x] += 1

        prime = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29]
        mask = [0] * 31

        for i in range(2, 31):
            x = i
            m = 0
            ok = True

            for j, p in enumerate(prime):
                cnt = 0
                while x % p == 0:
                    cnt += 1
                    x //= p

                if cnt > 1:
                    ok = False
                    break

                if cnt == 1:
                    m |= (1 << j)

            if ok:
                mask[i] = m

        dp = [0] * 1024
        dp[0] = 1

        for i in range(2, 31):
            if freq[i] == 0 or mask[i] == 0:
                continue

            nxt = dp[:]

            for m in range(1024):
                if (m & mask[i]) == 0:
                    nxt[m | mask[i]] = (nxt[m | mask[i]] + dp[m] * freq[i]) % mod

            dp = nxt

        ans = sum(dp[1:]) % mod

        ones = pow(2, freq[1], mod)

        return (ans * ones) % mod