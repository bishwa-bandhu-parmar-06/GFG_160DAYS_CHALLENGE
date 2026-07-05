# Max Gap Between Two Same
# Difficulty: EasyAccuracy: 47.57%Submissions: 11K+Points: 2
# Given a string s consisting of lowercase English letters, find the maximum number of characters between any two identical characters. If no character repeats, return -1.

# Examples :

# Input: s = "socks"
# Output: 3
# Explanation: There are 3 characters between the two occurrences of 's'.
# Input: s = "for"
# Output: -1
# Explanation: No repeating character present.
# Constraints:
# 1 ≤ |s| ≤ 105

class Solution:

    def maxCharGap(self, s: str) -> int:
        seen = [-1]*26
        ans=0
        for i,c in enumerate(s):
            j = ord(c)-ord('a')
            if seen[j]==-1:
                seen[j] = i
            else:
                ans = max(ans,i-seen[j])
        return ans-1
