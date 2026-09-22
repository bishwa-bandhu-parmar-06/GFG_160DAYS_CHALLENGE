# Longest Matching in Dictionary with Removals
# Difficulty: MediumAccuracy: 43.54%Submissions: 24K+Points: 4
# Given a lowercase string s and a dictionary d[] containing lowercase words, find the longest word in the dictionary that can be obtained by deleting some characters from s without changing the order of the remaining characters.

# Note: If multiple words have the same maximum length, return the lexicographically smallest one. If no valid word exists, return an empty string.

# Examples : 

# Input: d = ["ale", "apple", "monkey", "plea"], s = "abpcplea"
# Output: "apple" 
# Explanation: After deleting "b", "c", "a" s became "apple" which is present in d.
# Input: d = ["a", "b", "c"], s = "abpcplea"
# Output: "a"
# Explanation: After deleting "b", "p", "c", "p", "l", "e", "a" s became "a" which is present in d.
# Constraints:
# 1 ≤ |s| ≤ 5 * 105
# 1 ≤ n ≤ 104, where n is the number of words in dictionary
# 1 ≤ m ≤ 100, where m is the length of word in dictionary
# s and all words in dictionary consist only of lowercase English letters.


class Solution:
    def findLongestWord(self, s: str, d: list) -> str:
        # code here
        from bisect import bisect_left

        chars = [[] for _ in range(26)]
        for i, e in enumerate(s):
            idx = ord(e)-ord('a')
            chars[idx].append(i)

        def ok(ss, chars):
            start = 0
            for e in ss:
                lst = chars[ord(e)-ord('a')]
                i = bisect_left(lst, start)
                if i == len(lst):
                    return False
                start = lst[i]+1
            return True

        ret = ""
        for ss in d:
            if ok(ss, chars):
                if len(ss) > len(ret):
                    ret = ss
                elif len(ss) == len(ret):
                    ret = min(ret, ss)

        return ret