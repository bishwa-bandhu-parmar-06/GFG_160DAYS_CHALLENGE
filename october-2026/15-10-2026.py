# Maximum Without 3 Consecutive Set Bits
# Difficulty: MediumAccuracy: 58.04%Submissions: 22K+Points: 4
# Given a non-negative integer n, you can only change a set bit (1) to an unset bit (0). Find the maximum possible value of n such that its binary representation does not contain three consecutive set bits (111) after performing zero or more allowed operations.

# Examples:

# Input: n = 2
# Output: 2
# Explanation: The binary representation of 2 is 10, which does not contain three consecutive set bits. Therefore, no change is required.
# Input: n = 7
# Output: 6
# Explanation: The binary representation of 7 is 111, which contains three consecutive set bits. Changing the rightmost set bit to 0 gives: 111 -> 110. Thus, the maximum possible value is 6.
# Constraints:

# 0 ≤ n ≤ 109



class Solution:

    def maxValue(self, n: int) -> int:
            if n == 0:
                return 0
            mask = 1 << n.bit_length() - 1
            answer, ones = n, 0
            while mask > 0:
                if mask & n:
                    ones += 1
                    if ones == 3:
                        answer ^= mask
                        ones = 0
                else:
                    ones = 0
                mask >>= 1
            return answer