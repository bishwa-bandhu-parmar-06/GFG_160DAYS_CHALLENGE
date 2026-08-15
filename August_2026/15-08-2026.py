# Numbers Without d as Digit
# Difficulty: HardAccuracy: 49.0%Submissions: 15K+Points: 8
# Given a number n, count the numbers from 1 to n that don’t contain digit d in their decimal representation.

# Examples:

# Input: n = 25, d = 3
# Output: 22
# Explanation: From 1 to 25, the numbers 3, 13, and 23 contain the digit 3, so the answer is 25 - 3 = 22.
# Input: n = 5, d = 3
# Output: 4
# Explanation: From 1 to 5, only 3 contains the digit 3, so the count of numbers without digit 3 is 4.
# Constraints:

# 0 ≤ n ≤ 109
# 0 ≤ d ≤ 9


class Solution:
    def countWithout(self, n: int, d: int) -> int:
        if n == 0:
            return 0
    
        digits = str(n)
    
        from functools import lru_cache
    
        @lru_cache(None)
        def dp(pos, tight, started):
            if pos == len(digits):
                return 1 if started else 0
    
            limit = int(digits[pos]) if tight else 9
            ans = 0
    
            for digit in range(limit + 1):
                new_tight = tight and (digit == limit)
    
                # Leading zero is not considered part of the number
                if not started and digit == 0:
                    ans += dp(pos + 1, new_tight, False)
                elif digit != d:
                    ans += dp(pos + 1, new_tight, True)
    
            return ans
    
        return dp(0, True, False)