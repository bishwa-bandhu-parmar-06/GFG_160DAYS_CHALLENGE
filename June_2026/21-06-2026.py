# Choose and Swap
# Difficulty: MediumAccuracy: 22.67%Submissions: 91K+Points: 4
# Given a string s of lowercase English letters, you can swap all occurrences of any two distinct characters at most once. Return the lexicographically smallest string after this operation.
# Examples:

# Input: s = "ccad"
# Output: "aacd"
# Explanation: In ccad, we choose a and c and after doing the replacement operation once, we get aacd and this is the lexicographically smallest string possible. 
# Input: s = "abba"
# Output: "abba"
# Explanation: In abba, we can get baab after doing the replacement operation once for a and b but that is not lexicographically smaller than abba. So, the answer is abba. 
# Constraints:
# 1 ≤ |s| ≤ 105


class Solution:
    def chooseSwap(self, s):
        # code here
        n=len(s)
        dic={}
        for i in range(n):
            dic[s[i]]=i
        change_from=''
        change_to=''
        check=set()
        for i in range(n):
            el=s[i]
            boo=False
            for j in range(ord('a'),ord(el)):
                alpha=chr(j)
                if alpha in dic and dic[alpha]>i and alpha not in check:
                    change_from=s[i]
                    change_to=alpha
                    boo=True
                    break
            check.add(el)
            if boo:
                break
        if not change_from:
            return s
        ans=''
        for el in s:
            if el==change_from:
                ans+=change_to
            elif el==change_to:
                ans+=change_from
            else:
                ans+=el
        return ans