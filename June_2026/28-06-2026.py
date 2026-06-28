# k Times Appearing Adjacent Two 1's
# Difficulty: MediumAccuracy: 49.19%Submissions: 4K+Points: 4
# Given two integers n and k, count the number of binary strings of length n where adjacent 1 appear k times.

# Since the answer can be huge, return it modulo 109+7.


class Solution:
    def countStrings(self, n, k):
        from functools import cache
        @cache
        def dfs(n=n,k=k,p=''):
            if n==0:
                return k==0
            if k<0:
                return 0
            ret=dfs(n-1,k,'0')
            ret+=dfs(n-1,k-(1 if p=='1' else 0),'1')
            return ret%1_000_000_007
        return dfs()