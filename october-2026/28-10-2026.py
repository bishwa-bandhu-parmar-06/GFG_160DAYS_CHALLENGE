

# Nth in Concatenated Decimal String
# Difficulty: MediumAccuracy: 49.47%Submissions: 1K+Points: 4Average Time: 15m
# Consider a string s formed by concatenating the decimal representations of all positive integers in order:

# s = "12345678910111213141516171819202122232425262728293031..."

# Given an integer n, find the nth character (1-based indexing) in the string s.

# Examples:

# Input: n = 10
# Output: '1'
# Explanation: The 10th in "1234567891.." character is '1'.
# Input: n = 11
# Output: '0'
# Explanation: The 11th character in "12345678910.."  is '0'.
# Constraints:

# 1 ≤ n ≤ 109



class Solution:

    def nthCharacter(self, n):
        # code here
        digit = 1
        l = 9*10**(digit-1)*digit
        while n - l >= 0:
            n -= l
            digit += 1
            l = 9*10**(digit-1)*digit
        
        k = n//digit
        r = n%digit
        final_number = 10**(digit-1) - 1 + n//digit + (1 if r > 0 else 0)
        return str(final_number)[r-1]