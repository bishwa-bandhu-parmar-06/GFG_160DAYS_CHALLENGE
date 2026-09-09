# Max Digit Sum Number in 1 to n
# Difficulty: EasyAccuracy: 19.66%Submissions: 3K+Points: 2
# Given a number n, find a number in the range from 1 to n such that its digit sum is maximum. If there are multiple such numbers, return the largest of them.

# Examples:

# Input: n = 48
# Output: 48
# Explanation: There are two numbers with maximum digit sum = 12. The numbers are 48 and 39. Since 48 > 39, so 48 is the answer.
# Input: n = 90
# Output: 89
# Explanation: 89 gives us the largest digit sum in the range from 1 to n. Hence the answer is 89. 
# Constraints:

# 1 ≤ n ≤ 109

class Solution:
    def findMax(self, n):
        if n <= 9:
            return n
        s = str(n)
        m = len(s)
        if s[1] >= "8" and all(s[i] == "9" for i in range(2, m)):
            return n
        i = 1
        while s[i] == "9":
            i += 1
        output = [s[:i - 1]]
        output.append(chr(ord(s[i - 1]) - 1))
        output.append("9" * (m - i))
        return int("".join(output))
