# Pairs with Given GCD and LCM
# Difficulty: EasyAccuracy: 62.15%Submissions: 8K+Points: 2
# Given two integers x and y representing the GCD and LCM of two unknown positive integers a and b, count the number of valid pairs (a, b) satisfying these conditions. Note that (a, b) and (b, a) are counted as distinct pairs when a ≠ b.

# Examples:

# Input: x = 2, y = 12
# Output: 4
# Explanation: The valid pairs are (2, 12), (4, 6), (6, 4), and (12, 2), since each pair has GCD = 2 and LCM = 12.
# Input: x = 6, y = 4
# Output: 0
# Explanation: LCM must always be a multiple of GCD. Since y is not divisible by x, no valid pair exists.
# Constraints:
# 1 ≤ x, y ≤ 104


class Solution:
    def pairCount(self, x, y):
        if y % x != 0:
            return 0

        n = y // x
        count = 0

        for a in range(1, n + 1):
            if n % a == 0:
                b = n // a

                if self.gcd(a, b) == 1:
                    count += 1

        return count

    def gcd(self, a, b):
        while b != 0:
            a, b = b, a % b
        return a