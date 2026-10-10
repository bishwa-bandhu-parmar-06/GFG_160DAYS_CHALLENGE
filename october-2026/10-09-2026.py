# Balancing with Distinct Powers
# Solved
# Difficulty: EasyAccuracy: 61.98%Submissions: 5K+Points: 2
# Given a simple weighing scale with two pans, a target weight b, and a set of weights where each weight is a distinct power of a, find if the scale can be balanced such that:

# b + (some powers of a) = (some other powers of a)

# Note: Exactly one weight is available for each power of a, so each power can be used at most once.

# Examples:

# Input: a = 4, b = 11
# Output: true
# Explanation: 11 + 4 + 1 = 16. So, target = 11 can be balanced using powers of 4.
# Input: a = 3, b = 5
# Output: true
# Explanation: 5 + 3 + 1 = 9. So, target = 5 can be balanced using powers of 3.
# Constraints:

# 2 ≤ a ≤ 109
# 1 ≤ b ≤ 109


class Solution:
    def balancePan(self, a, b):
            if a == 2:
                return True
            # "b" can have only [0, 1, a - 1]
            # in its a-based representation
            while b:
                r = b % a
                if r == 0 or r == 1:
                    b //= a
                elif r == a - 1:
                    b = (b + 1) // a
                else:
                    return False
            return True