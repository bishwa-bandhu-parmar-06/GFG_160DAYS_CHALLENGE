# Min Flips for Alternate
# Difficulty: EasyAccuracy: 48.58%Submissions: 58K+Points: 2
# Given a binary string s, we can flip any bit (change 0 to 1 or 1 to 0) to make the string alternating. A string is called alternating if no two adjacent characters are the same.

# Find the minimum number of bit flips required to make the string alternating.

# Examples:

# Input: s = "001"
# Output: 1
# Explanation: Flip the bit at index 0 from 0 to 1 to obtain "101", which is an alternating binary string. Hence, the minimum number of flips required is 1.
# Input: s = "0001010111" 
# Output: 2
# Explanation: Flip the bit at indices 1 and 8 to obtain "0101010101", which is an alternating binary string. Hence, the minimum number of flips required is 2.
# Constraints:

# 1 ≤ s.size() ≤ 105
# s consists only of the characters 0 and 1



class Solution:
    def minFlips(self, s):
        cnt1 = sum(s[i] != str((i + 1) % 2) for i in range(len(s)))
        cnt0 = sum(s[i] != str(i % 2) for i in range(len(s)))

        return min(cnt1, cnt0)