# Count Subsequences Divisible by n
# Difficulty: MediumAccuracy: 25.11%Submissions: 5K+Points: 4
# Given a numeric string s containing only digits and an integer n, count the number of non-empty subsequences of s whose numeric value is divisible by n. Return the answer modulo 1e9 + 7.

# Examples:

# Input: s = "1234", n = 4
# Output: 4
# Explanation: The subsequences 4, 12, 24 and 124 are divisible by 4.
# Input: s = "330", n = 6
# Output: 4
# Explanation: The subsequences 30, 30, 330 and 0 are divisible by 6.
# Constraints:
# 1 ≤ |s| * n ≤ 106


class Solution:
    def countSubsequences(self, s, n):
        # code here
        
        
   
            MOD = 10**9 + 7

            dp = [0] * n

            for ch in s:
                d = int(ch)

                # Copy existing subsequences
                new_dp = dp[:]

                # Start a new subsequence with this digit
                new_dp[d % n] = (new_dp[d % n] + 1) % MOD

                # Append current digit to every existing subsequence
                for r in range(n):
                    if dp[r]:
                        new_r = (r * 10 + d) % n
                        new_dp[new_r] = (new_dp[new_r] + dp[r]) % MOD

                dp = new_dp

            return dp[0] % MOD