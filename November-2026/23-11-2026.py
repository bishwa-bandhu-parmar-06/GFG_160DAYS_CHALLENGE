# Character at Position in Infinite String
# Difficulty: MediumAccuracy: 30.88%Submissions: 3K+Points: 4
# Given a string s and an integer pos, an infinite string is constructed by repeatedly applying the following operation. In the i-th step, append i consecutive $ characters, followed by the reverse of the current string, to the current string.

# Formally, if the current string is s, update it as:

# s = s + ('$' repeated i times) + reverse(s)
# The initial string is the given s, and the process continues indefinitely.

# Find and return the character at the pos(1-based indexing) in the resulting infinite string.

# Examples:

# Input: s = "12345", pos = 3
# Output: 3
# Explanation: In "12345...", the character at pos 3 is 3.
# Input: s = "12345", pos = 10
# Output: 2
# Explanation: In "12345$54321...", the character at pos 10 is 2.
# Input: s = "abc", pos = 7
# Output: a
# Explanation: In "abc$cba...", the character at pos 7 is a.
# Constraints:

# 1 ≤ s.size() ≤ 105
# 1 ≤ pos ≤ 109
# s consists of English alphabets and digits


class Solution:
    def posInfinite(self, s: str, pos: int) -> str:
            # code here
            n = len(s)
            k = 0
            while n < pos:
                k += 1
                n = n*2 + k

            left = True
            while k > 0:
                n = (n-k)//2
                if pos > n and pos <= n+k:
                    return '$'

                if pos > n+k:
                    pos -= n+k
                    left = False
                else:
                    left = True
                k -= 1
            #print(f"{reversed = }, {pos = }")
            return s[pos-1] if left else s[n-pos]