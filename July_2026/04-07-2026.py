# Substrings with more 1's than 0's
# Difficulty: HardAccuracy: 57.87%Submissions: 22K+Points: 8
# Given a binary string s consists only of 0s and 1s. Calculate the number of substrings that have more 1s than 0s.

# Examples:

# Input: s = "011"
# Output: 4
# Explanation: There are 4 substring which has more 1s than 0s. i.e "011","1","11" and "1"
# Input: s = "0000"
# Output: 0
# Explanation: There is no substring with more 1s than 0s
# Constraints:
# 1 < |s| <  6 * 104



class Solution:
    def countSubstring(self, s):
        n = len(s)
        pref_balance_counts = [0] * (2 * n + 1)
        curr_balance = n
        pref_balance_counts[curr_balance] = 1
        curr_count = total_count = 0
        for d in s:
            if d == "1":
                curr_count += pref_balance_counts[curr_balance]
                curr_balance += 1
            else:
                curr_balance -= 1
                curr_count -= pref_balance_counts[curr_balance]
            total_count += curr_count
            pref_balance_counts[curr_balance] += 1
        return total_count