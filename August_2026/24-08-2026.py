# Count Prefix-Balanced Binary Strings
# Solved
# Difficulty: EasyAccuracy: 44.17%Submissions: 17K+Points: 2
# Given an integer n, count the number of binary strings of length 2 * n that contain exactly n ones and n zeros such that every prefix of the string contains at least as many ones as zeros. Since the answer can be very large, return it modulo 109 + 7.

# Examples:

# Input: n = 2
# Output: 2
# Explanation: "1100", "1010" are two such strings of size 4 which have exactly two 1's in each.
# Input: n = 3
# Output: 5
# Explanation: "111000", "101100", "101010", "110010", "110100" are such 5 strings which have exactly three 1's in each.
# Constraints:

# 1 ≤ n ≤ 1000


class Solution:
    def prefixStrings(self, n: int) -> int:
       MOD = 10**9 + 7
    
       # factorials up to 2n
       fact = [1] * (2 * n + 1)
       for i in range(1, 2 * n + 1):
           fact[i] = fact[i - 1] * i % MOD
    
       # nCr = fact[2n] / (fact[n] * fact[n])
       # Fermat's little theorem: a^(-1) = a^(MOD-2) mod MOD
       inv_fact_n = pow(fact[n], MOD - 2, MOD)
    
       comb = fact[2 * n] * inv_fact_n % MOD
       comb = comb * inv_fact_n % MOD
    
       # Catalan number = C(2n, n) / (n + 1)
       ans = comb * pow(n + 1, MOD - 2, MOD) % MOD
    
       return ans